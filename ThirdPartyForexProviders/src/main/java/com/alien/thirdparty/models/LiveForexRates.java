package com.alien.thirdparty.models;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LiveForexRates {
	@JsonProperty("base")
	private String base;
	@JsonProperty("date")
	private String date;
	@JsonProperty("rates")
	private Map<String,Double> rates;
	

	
	public LiveForexRates()
	{
		
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	

	
	
	
	public Map<String, Double> getRates() {
		return rates;
	}
	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
	@Override
	public String toString() {
		return "RateModel [base=" + base + ", date=" + date + ", rates=" + rates + "]";
	}
	
	
		

		
	


	
	

}
