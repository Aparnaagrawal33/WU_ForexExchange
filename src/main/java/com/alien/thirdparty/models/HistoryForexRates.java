package com.alien.thirdparty.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HistoryForexRates {
	
	
	
	@JsonProperty("rates")
	private Map<String,Map<String,Object>> rates;
	public HistoryForexRates() {}
	
	public Map<String, Map<String, Object>> getRates() {
		return rates;
	}

	public void setRates(Map<String, Map<String, Object>> rates) {
		this.rates = rates;
	}

	@Override
	public String toString() {
		return "HistoryForexRates [rates=" + rates + "]";
	}
	
}
