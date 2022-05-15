package com.springapigateway.currencyexchnange.service;

import java.util.HashMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springapigateway.currencyexchnange.model.CurrencyConversion;

@Service
public class CurrencyExchangeService {
	Logger logUtil = LoggerFactory.getLogger(CurrencyExchangeService.class);

	
	@Autowired
	Environment env;
	
	public CurrencyConversion getCurrencyValuesfromExternalAPI(String fromCurrency, String toCurrency) {
		if (!fromCurrency.isBlank() && !toCurrency.isBlank()) {
			logUtil.info("from currency is " + fromCurrency);
			logUtil.info("toCurrency is " + toCurrency);
			String finalResult = fetchingCurrentValue(fromCurrency, toCurrency);
			if (null != finalResult && !finalResult.isBlank()) {
				return new CurrencyConversion(UUID.randomUUID().toString(), fromCurrency, toCurrency, finalResult, env.getProperty("server.port"));
			}
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String fetchingCurrentValue(String fromCurrency, String toCurrency) {
		try {

			HttpHeaders headers = new HttpHeaders();
			headers.set("apikey", env.getProperty("apiKey"));
			HttpEntity<HashMap> response1 = new RestTemplate()
					.exchange("https://api.apilayer.com/currency_data/convert?to=" + toCurrency + "&from="
							+ fromCurrency + "&amount=1", HttpMethod.GET, new HttpEntity(headers), HashMap.class);
			HashMap<String, Object> response = response1.getBody();
			if(null != response.get("success")) {
				boolean sucessfactor = (boolean)(response.get("success"));
				if(sucessfactor) {
					if (null != response && null != response.get("result")) {
						String resultValue = Double.toString((double) response.get("result"));
						if (!resultValue.isBlank()) {
							logUtil.info("final conversion rate is " + resultValue);
							return resultValue;
						}
					}
				}else {
					if(null !=  response.get("error") && null != ((HashMap<String , Object>)response.get("error")).get("info")) {
						String errorText = (String)((HashMap<String , Object>)response.get("error")).get("info");
						logUtil.error("fetching the conversion failed because of " + errorText);
						return null;
					}
				}
			}
		} catch (Exception e) {
			logUtil.info("Some error has occured while fetching data");
			e.printStackTrace();
		}
		return null;
	}
}
