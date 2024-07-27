package com.example.jmsutil.publisher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@PostMapping("/publishMessage")
	public ResponseEntity<String> publishMessage (@RequestBody String message) {
		try {
			jmsTemplate.convertAndSend("genesis.queue", message);
			
			return new ResponseEntity<String>("Sent", HttpStatus.OK);
		}
		catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
