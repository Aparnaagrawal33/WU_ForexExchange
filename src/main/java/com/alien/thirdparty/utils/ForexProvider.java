package com.alien.thirdparty.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.alien.thirdparty.models.LiveForexRates;


public class ForexProvider implements ForexProviders {

	
	private String nameOfProvider=null;
	@Autowired()
	@Qualifier("map")
	private Map<String,Double> rates;
	private String base;
	private String date;
	
	public ForexProvider() {
	
	}

	public String getNameOfProvider() {
		return nameOfProvider;
	}

	public void setNameOfProvider(String nameOfProvider) {
		this.nameOfProvider = nameOfProvider;
	}
	

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
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

	

	@Override
	public ForexProviders setObject(Double value,String name, LiveForexRates obj) {
		setNameOfProvider(name);
		setBase(obj.getBase());
		setDate(obj.getDate());
		for(Map.Entry<String,Object> en :obj.getRates().entrySet()) {
			this.rates.put(en.getKey(),(Double)en.getValue()+(Double)en.getValue()*value);
		}
				
		return this ;
	}

	

	@Override
	public ForexProviders setObject(Float value, String name, LiveForexRates obj) {
		setNameOfProvider(name);
		setBase(obj.getBase());
		setDate(obj.getDate());
		for(Map.Entry<String,Object> en :obj.getRates().entrySet()) {
			this.rates.put(en.getKey(),(Double)en.getValue()+(Double)en.getValue()*value);
		}
				
		return this ;
	}
	
	@Override
	public String toString() {
		return "ForexProvider [nameOfProvider=" + nameOfProvider + ", rates=" + rates + ", base=" + base + ", date="
				+ date + "]";
	}
	
	
	
	

}
