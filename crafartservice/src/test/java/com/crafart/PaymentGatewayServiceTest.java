package com.crafart;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class PaymentGatewayServiceTest {

	@Ignore
	public void testPayUMoneyRestService() {

		try {
			URI URI = new URI("https://test.payu.in/_payment");
			
			RestTemplate rest = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> entity = new HttpEntity<String>("", headers);

			ResponseEntity<String> response = rest.postForEntity(URI, entity, String.class);
			String responseBody = response.getBody();
		} catch (RestClientException | URISyntaxException restClntExp) {
			restClntExp.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void dummyTest(){
		
	}

	private class PaymentData{
		
	}
	
}
