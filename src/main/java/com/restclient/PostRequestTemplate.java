package com.restclient;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.restclient.model.Transaction;

public class PostRequestTemplate {
	
	public void saveTransaction(Transaction transaction){
		final String uri = "http://localhost:8080/transactions/transaction";
		System.out.println("[request]    "+transaction.toString());
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.postForEntity( uri,transaction, String.class);
		System.out.println("[response]   "+response.getStatusCode());
	}
}
