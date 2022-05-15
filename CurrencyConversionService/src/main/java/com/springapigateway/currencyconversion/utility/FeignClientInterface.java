package com.springapigateway.currencyconversion.utility;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springapigateway.currencyconversion.model.CurrencyConverted;

@FeignClient(value = "CurrencyExchangeService")
public interface FeignClientInterface {

	@GetMapping(value = "/currency-exchange/from/{fromCurrency}/to/{toCurrency}",consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public CurrencyConverted convertCurrency(@PathVariable(value = "fromCurrency") String fromCurrency,
			@PathVariable(value = "toCurrency") String toCurrency);
}
