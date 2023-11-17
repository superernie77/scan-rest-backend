package com.se77.scan;

import org.springframework.web.client.RestClient;

import com.se77.scan.domain.ScanMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment =  WebEnvironment.DEFINED_PORT)
public class ScanRestBackendApplicationTests {
	
	
	 private RestClient restClient = RestClient.create("http://localhost:8080");


	@Test
	public void postMessageAndRetrieveIt() {
		
		ScanMessage newMessage = new ScanMessage()
				.withBarcode("12345456788")
				.withCreatedBy("Ernie")
				.withCreationTsp(Calendar.getInstance())
				.withMessage("Hi There!");
		
		ScanMessage message = restClient.post()
				  .uri("/message")
				  .body(newMessage)
				  .accept(MediaType.APPLICATION_JSON)
				  .retrieve()
				  .body(ScanMessage.class);
		
		
		ScanMessage[] messages = restClient.get()
				  .uri("/message")
				  .accept(MediaType.APPLICATION_JSON)
				  .retrieve()
				  .body(ScanMessage[].class);
		
		assertTrue( messages.length == 1);
		
		assertEquals("12345456788", messages[0].getBarcode());
		
	}

}
