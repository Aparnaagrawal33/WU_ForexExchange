package com.alien.thirdparty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.alien.thirdparty.models.Error;
import com.alien.thirdparty.models.LiveForexRates;
import com.alien.thirdparty.models.Message;
import com.alien.thirdparty.utils.ForexProvider;
import com.fasterxml.jackson.databind.ObjectMapper;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/forexProviders")
public class RestController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ForexProvider forexProvider;
	@Autowired
	ObjectMapper objectMapper;
	@Value("${rest.property}")
	private String URL;
	@GetMapping("/{id}")
	public ResponseEntity<String> getObj(@PathVariable("id") String id,@RequestParam("base") String base) {
		LiveForexRates result=null;
		String json = null;
		
		try{
			result=restTemplate.getForObject(URL+base, com.alien.thirdparty.models.LiveForexRates.class);
		}
		catch (RestClientException e) {
			try {
				
				json=objectMapper.writeValueAsString(new Message(false,new Error(500,"Newtork is unreachable")));
			}
			catch (Exception e2) {
				return new ResponseEntity<String>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<String>(json,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		catch (Exception e2) {
			return new ResponseEntity<String>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		switch (id) {
		case "1":
			forexProvider.setObject(0.02,"Provider 1",result);
			try {
				json=objectMapper.writeValueAsString(forexProvider);

			}
			catch (Exception e) {
				return new ResponseEntity<String>("something went wrong",HttpStatus.OK);
			}
			
			return new ResponseEntity<String>(json,HttpStatus.OK);
		case "2":
			forexProvider.setObject(0.03,"Provider 2",result);
			try {
				json=objectMapper.writeValueAsString(forexProvider);
			}
			catch (Exception e) {
				return new ResponseEntity<String>("something went wrong",HttpStatus.OK);
			}
			return new ResponseEntity<String>(json,HttpStatus.OK);
		case "3":
			
			forexProvider.setObject(0.01,"Provider 3",result);
			try {
				json=objectMapper.writeValueAsString(forexProvider);
			}
			catch (Exception e) {
				return new ResponseEntity<String>("something went wrong",HttpStatus.OK);
			}
			return new ResponseEntity<String>(json,HttpStatus.OK);
		case "4":
			forexProvider.setObject(0.025,"Provider 4",result);
			try {
				json=objectMapper.writeValueAsString(forexProvider);
			}
			catch (Exception e) {
				return new ResponseEntity<String>("something went wrong",HttpStatus.OK);
			}
			return new ResponseEntity<String>(json,HttpStatus.OK);
		case "5":
			forexProvider.setObject(0.015,"Provider 5",result);
			try {
				json=objectMapper.writeValueAsString(forexProvider);
			}
			catch (Exception e) {
				return new ResponseEntity<String>("something went wrong",HttpStatus.OK);
			}
			return new ResponseEntity<String>(json,HttpStatus.OK);
		case "6":
			forexProvider.setObject(0.0165,"Provider 6",result);
			try {
				json=objectMapper.writeValueAsString(forexProvider);
			}
			catch (Exception e) {
				return new ResponseEntity<String>("something went wrong",HttpStatus.OK);
			}
			return new ResponseEntity<String>(json,HttpStatus.OK);
		case "7":
			forexProvider.setObject(0.0115,"Provider 7",result);
			try {
				json=objectMapper.writeValueAsString(forexProvider);
			}
			catch (Exception e) {
				return new ResponseEntity<String>("something went wrong",HttpStatus.OK);
			}
			return new ResponseEntity<String>(json,HttpStatus.OK);
		case "8":
			forexProvider.setObject(0.0125,"Provider 8",result);
			try {
				json=objectMapper.writeValueAsString(forexProvider);
			}
			catch (Exception e) {
				return new ResponseEntity<String>("something went wrong",HttpStatus.OK);
			}
			return new ResponseEntity<String>(json,HttpStatus.OK);
		case "9":
			forexProvider.setObject(0.0355,"Provider 9",result);
			try {
				json=objectMapper.writeValueAsString(forexProvider);
			}
			catch (Exception e) {
				return new ResponseEntity<String>("something went wrong",HttpStatus.OK);
			}
			return new ResponseEntity<String>(json,HttpStatus.OK);
		case "10":
			forexProvider.setObject(0.035,"Provider 10",result);
			try {
				json=objectMapper.writeValueAsString(forexProvider);
			}
			catch (Exception e) {
				return new ResponseEntity<String>("something went wrong",HttpStatus.OK);
			}
			return new ResponseEntity<String>(json,HttpStatus.OK);
		default:
			return new ResponseEntity<String>("Something went wrong.. ",HttpStatus.UNPROCESSABLE_ENTITY);
		
		}
		
	}
	@GetMapping("/noOfProviders")
	public String getNoOfProvidersAvaliable() {
		return "10";
	}
	
}
