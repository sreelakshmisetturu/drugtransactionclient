package com.restclient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class FetchFrequency {
	
	public void fetchTopMerchants(long userId){
		final String uri = "http://localhost:8080/frequentmerchant/{userId}";
		Map<String, Long> params = new HashMap<String, Long>();
	    params.put("userId", userId);
	     
	    RestTemplate restTemplate = new RestTemplate();
	    ResponseEntity<ArrayList> response = restTemplate.getForEntity(uri, ArrayList.class, params);
	    if(response.getBody().size()==0){
	    	System.out.println("userId: "+ userId +", Error - Too few transactions");
	    }else{
	    	System.out.println("top 3 most visited merchants for user " + userId + " are "+response.getBody().toString());
	    }
	    
	}

}
