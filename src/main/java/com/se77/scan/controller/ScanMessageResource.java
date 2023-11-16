package com.se77.scan.controller;

import java.util.Calendar;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.se77.scan.domain.ScanMessage;
import com.se77.scan.repo.ScanMessageRepository;

@RestController
public class ScanMessageResource {
	
	@Autowired
	private ScanMessageRepository scanMessageRepo;
	
	@RequestMapping(path="/message", method = RequestMethod.POST )
	public ResponseEntity<ScanMessage>  postMessage(@RequestBody ScanMessage message) {
		message.setCreationTsp(Calendar.getInstance());
		message.setId(null);
		scanMessageRepo.save(message);
		
		return new ResponseEntity<ScanMessage>(message, HttpStatus.OK);
	}
	
	@RequestMapping(path="/message", method = RequestMethod.GET ) 
	public List<ScanMessage> getAllMessages() {		
		return scanMessageRepo.findAll();
	}

}
