package com.alien.thirdparty.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.alien.thirdparty.utils.ForexProvider;
import com.alien.thirdparty.utils.ForexProviders;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeanConfig {
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	@Bean
	public ForexProvider getProvider()
	{
		return new ForexProvider();
	}
	@Bean
	@Qualifier("map")
	public Map<String, Double> getMap()
	{
		return new HashMap<>();
	}
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}


