package com.alien.thirdparty.utils;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import com.alien.thirdparty.models.LiveForexRates;


public class ForexProvider implements ForexProviders {

	
	private String nameOfProvider=null;
	@Autowired
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
	public void setObject(Double value,String name, LiveForexRates obj) {
		setNameOfProvider(name);
		setBase(obj.getBase());
		setDate(obj.getDate());
		for(Entry<String, Double> en :obj.getRates().entrySet()) {
			this.rates.put(en.getKey(),(Double)en.getValue()-(Double)en.getValue()*value);
			
		}
	}
	

	

	@Override
	public void setObject(Float value, String name, LiveForexRates obj) {
		setNameOfProvider(name);
		setBase(obj.getBase());
		setDate(obj.getDate());
		for(Entry<String, Double> en :obj.getRates().entrySet()) {
			this.rates.put(en.getKey(),(Double)en.getValue()-(Double)en.getValue()*value);
		}
	
		
	}
	

	@Override
	public String toString() {
		return "ForexProvider [nameOfProvider=" + nameOfProvider + ", rates=" + rates + ", base=" + base + ", date="
				+ date + "]";
	}
	
	
	
	
	
	

}
