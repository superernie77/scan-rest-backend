package com.se77.scan.controller;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.se77.scan.domain.ScanMessage;
import com.se77.scan.repo.ScanMessageRepository;

@RestController
public class ScanMessageResource {
	
	
	@PostConstruct
	public void setup() {
		ScanMessage message = new ScanMessage();
		message.setBarcode("1223");
		message.setCreatedBy("ENE");
		message.setCreationTsp(Calendar.getInstance());
		message.setFormat("String");
		message.setMessage("First demo message");
		scanMessageRepo.save(message);
	}
	
	@Autowired
	private ScanMessageRepository scanMessageRepo;
	
	@RequestMapping(path="/message", method = RequestMethod.POST )
	public void postMessage(@RequestBody ScanMessage message) {
		message.setCreationTsp(Calendar.getInstance());
		message.setId(null);
		scanMessageRepo.save(message);
	}
	
	@RequestMapping(path="/message", method = RequestMethod.GET ) 
	public List<ScanMessage> getAllMessages() {		
		return scanMessageRepo.findAll();
	}

}
