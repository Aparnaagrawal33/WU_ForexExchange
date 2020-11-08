package com.alien.thirdparty.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.alien.thirdparty.models.LiveForexRates;

public class ForexProviderListImpl implements ForexProviderList{
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ForexProvider forexProvider;
	
	
	List<ForexProvider> providerList = new ArrayList<>();
	
	public ForexProviderListImpl() {
		LiveForexRates result  = restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base=INR", com.alien.thirdparty.models.LiveForexRates.class);
		providerList.add((ForexProvider) forexProvider.setObject(0.2,"Provider 1",result));
		providerList.add((ForexProvider) forexProvider.setObject(0.15,"Provider 2",result));
		providerList.add((ForexProvider) forexProvider.setObject(0.18,"Provider 3",result));
		providerList.add((ForexProvider) forexProvider.setObject(0.22,"Provider 4",result));
		providerList.add((ForexProvider) forexProvider.setObject(0.08,"Provider 5",result));
	
	}
	
	public List<ForexProvider> getProviderList() {
		return providerList;
	}

	@Override
	public void addProvider(ForexProviders fp) {
		providerList.add((ForexProvider) fp);
	}
}
