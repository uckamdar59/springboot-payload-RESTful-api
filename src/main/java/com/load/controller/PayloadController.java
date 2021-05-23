package com.load.controller;

import com.load.service.loadService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.load.entities.Payload;

import com.load.model.PayloadRequest;
import com.load.model.PayloadResponse;




@RestController
public class PayloadController {

	
	@Autowired
	private loadService load_service;
	

	@GetMapping("/load")
	public Payload getLoadsById(@RequestParam(name="id",required=false) String id){
		return load_service.getPayloadById(id);
	}
	

	
	@PostMapping("/load")
	public PayloadResponse payloadResponse(@RequestBody PayloadRequest payloadrequest) {
		return load_service.createPayload(payloadrequest);
	}

	
	@PutMapping("/load/{id}")
	public PayloadResponse updatePayloadResponse(@PathVariable(value = "id") String id,@RequestBody PayloadRequest payloadrequest) {
		
		return load_service.updatePayload(id,payloadrequest);
		
	}

	
	@DeleteMapping("/load/{id}")
	public void deletePayload(@PathVariable(value = "id") String id) {
			load_service.deletePayload(id);
		
	}
	
}
