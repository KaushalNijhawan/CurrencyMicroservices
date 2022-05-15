package com.springapigateway.currencyexchnange.resillence4j.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;


@RestController
@RequestMapping(value="/resillence")
public class Resillence4jController {

	private Logger logUtil = LoggerFactory.getLogger(Resillence4jController.class);
	@GetMapping("/test-dummy")
	//@Retry(name ="dummy",fallbackMethod = "handleFailure")
	@RateLimiter(name = "dummy")
	public String testDummyAPI() {
		logUtil.info("Retry for this API sing resilence");
		//ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/test", String.class);
		return "respone it is";
	}
	
	public String handleFailure(Exception ex) {
		return "this Service is down";
	}
}
