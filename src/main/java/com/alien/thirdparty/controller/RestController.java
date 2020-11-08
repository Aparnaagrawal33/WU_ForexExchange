package com.alien.thirdparty.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.alien.thirdparty.models.LiveForexRates;
import com.alien.thirdparty.utils.ForexProvider;
import com.alien.thirdparty.utils.ForexProviderListImpl;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/obj")
public class RestController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ForexProvider forexProvider;
	@Autowired
	ForexProviderListImpl providerList;
	
	public LiveForexRates getLiveRates() {
		return restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base=INR", com.alien.thirdparty.models.LiveForexRates.class);	
	}
	
	/*public void setObj() {
		LiveForexRates result=getLiveRates();
		//ForexProviderListImpl providerList = ForexProviderListImpl.getInstance();
		//forexProvider.setObject(0.2,"Provider 1",result);
		providerList.addProvider(forexProvider.setObject(0.2,"Provider 1",result));
		providerList.addProvider(forexProvider.setObject(0.15,"Provider 2",result));
		providerList.addProvider(forexProvider.setObject(0.18,"Provider 3",result));
		providerList.addProvider(forexProvider.setObject(0.22,"Provider 4",result));
		providerList.addProvider(forexProvider.setObject(0.08,"Provider 5",result));
		//return forexProvider.toString();
	}*/
	
	@GetMapping("")
	public List<ForexProvider> getObj() {
		//ForexProviderListImpl providerList = ForexProviderListImpl.getInstance();
		List<ForexProvider> pList = providerList.getProviderList();
		//for(ForexProvider l : pList)
		return  pList;
	}
		
	
	@GetMapping("/{providerName}")
	public String getProviderRate(@PathVariable String providerName) {
		LiveForexRates result=getLiveRates();
		if(providerName.equals("Provider 1"))
			forexProvider.setObject(0.2,"Provider 1",result);
		else if(providerName.equals("Provider 2"))
			forexProvider.setObject(0.15,"Provider 2",result);
		else if(providerName.equals("Provider 3"))
			forexProvider.setObject(0.18,"Provider 3",result);
		else if(providerName.equals("Provider 4"))
			forexProvider.setObject(0.22,"Provider 4",result);
		else if(providerName.equals("Provider 5"))
			forexProvider.setObject(0.08,"Provider 5",result);	
		return forexProvider.toString();
		
	}
	
	@GetMapping("/{newType}")
	public Double getObj(@PathVariable("newType") String newType) {
		Map<String, Double> currencyValue;
		double convertedValue = 0;
		LiveForexRates result = getLiveRates();
		forexProvider.setObject(0.2,"Provider 1",result);
		currencyValue = forexProvider.getRates();
		if(currencyValue.containsKey(newType))
			convertedValue = currencyValue.get(newType);
		return convertedValue;
	}
}
