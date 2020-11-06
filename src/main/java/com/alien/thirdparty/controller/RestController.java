package com.alien.thirdparty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.alien.thirdparty.models.LiveForexRates;
import com.alien.thirdparty.utils.ForexProvider;


@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ForexProvider forexProvider;
	@GetMapping("/obj")
	public String getObj() {
		LiveForexRates result=restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base=USD", com.alien.thirdparty.models.LiveForexRates.class);
		forexProvider.setObject(0.2,"Provider 1",result);
		return forexProvider.toString();
	}
}
