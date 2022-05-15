package com.springapigateway.currencyexchnange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springapigateway.currencyexchnange.model.CurrencyConversion;
import com.springapigateway.currencyexchnange.service.CurrencyExchangeService;

@RestController
@RequestMapping(value = "/currency-exchange")
public class CurrencyExchangeController {
	@Autowired
	CurrencyExchangeService currencyConversionService;
	Logger logUtil = LoggerFactory.getLogger(CurrencyExchangeController.class);

	@GetMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE }, value = "/from/{fromCurrency}/to/{toCurrency}")
	public ResponseEntity<CurrencyConversion> convertCurrency(@PathVariable(value = "fromCurrency") String fromCurrency,
			@PathVariable(value = "toCurrency") String toCurrency) {
		logUtil.info("message coming from " + fromCurrency + " going to " + toCurrency);
		if (!fromCurrency.isBlank() && !toCurrency.isBlank()) {
			CurrencyConversion response = currencyConversionService.getCurrencyValuesfromExternalAPI(fromCurrency,
					toCurrency);
			if (null != response) {
				return new ResponseEntity<>(currencyConversionService.getCurrencyValuesfromExternalAPI(
						fromCurrency.toUpperCase(), toCurrency.toUpperCase()), HttpStatus.OK);
			}

		}

		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
}
