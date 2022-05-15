package com.springapigateway.currencyexchnange.model;


public class CurrencyConversion {

	private String id;
	private String from;
	private String to;
	private String conversionMultiple;
	private String environment;

	
	public CurrencyConversion(String id, String from, String to, String conversionMultiple, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.environment = environment;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(String conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "CurrencyConversion [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", environment=" + environment + "]";
	}

}
