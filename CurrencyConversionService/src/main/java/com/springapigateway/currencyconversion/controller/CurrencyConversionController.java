package com.springapigateway.currencyconversion.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springapigateway.currencyconversion.model.CurrencyConverted;
import com.springapigateway.currencyconversion.utility.FeignClientInterface;

@RestController
@RequestMapping(value = "/currency-conversion")
public class CurrencyConversionController {

	 Logger logUtil = LoggerFactory.getLogger(CurrencyConversionController.class);

	@Autowired
	FeignClientInterface feignClientInterface;
	
	@GetMapping(value = "/to/{toCurrency}/from/{fromCurrency}/quantity/{quantity}")
	public ResponseEntity<CurrencyConverted> getCOnvertedCurrencyAmount(@PathVariable("toCurrency") String toCurrency , @PathVariable("fromCurrency") String fromCurrency,
			@PathVariable("quantity") String quantity) {
		if(!fromCurrency.isBlank() && !toCurrency.isBlank()) {
			try {
			CurrencyConverted object =  feignClientInterface.convertCurrency(fromCurrency, toCurrency);
			if(null != object.getConversionMultiple() && !object.getConversionMultiple().isBlank()) {
				object.setQuantity(quantity);
				object.setTotalCalculatedAmount(Double.toString(Double.parseDouble(object.getConversionMultiple())*Integer.parseInt(quantity)));
				return new ResponseEntity<>(object, HttpStatus.OK );
			}
		}catch(Exception e) {
			logUtil.error("Error in the request made for currencies from "+ fromCurrency + " to currency " + toCurrency);
		}
	}
		
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	
}
