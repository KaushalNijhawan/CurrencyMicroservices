package com.springapigateway.currencyconversion.model;

public class CurrencyConverted {
	private String id;
	private String from;
	private String to;
	private String conversionMultiple;
	private String quantity;
	private String totalCalculatedAmount;
	private String environment;

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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(String totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public String toString() {
		return "CurrencyConverted [id=" + id + ", from=" + from + ", to=" + to + ", conversionMultiple="
				+ conversionMultiple + ", quantity=" + quantity + ", totalCalculatedAmount=" + totalCalculatedAmount
				+ ", environment=" + environment + "]";
	}

}
