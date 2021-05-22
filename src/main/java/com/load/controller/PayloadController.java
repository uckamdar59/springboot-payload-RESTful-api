package com.load.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;



import com.load.service.loadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	private loadServiceImpl loadService;
	


	
	
	
	
		
	
	
	@GetMapping("/load")
	public List<Payload> getLoadsById1(@RequestParam(name="id",required=false) Long loadId){
			return loadService.getPayloadById(loadId);
	}
	

	
	@PostMapping("/load")
	public PayloadResponse payloadResponse(@RequestBody PayloadRequest payloadrequest) {
		//System.out.print(load.getId());
		return loadService.createPayload(payloadrequest);
	}

	
	@PutMapping("/load")
	public PayloadResponse updatePayloadResponse(@RequestBody PayloadRequest payloadrequest) {
		
		return loadService.updatePayload(payloadrequest);
		
	}

	
	@DeleteMapping("/load/{id}")
	public void deletePayload(@PathVariable(value = "id") Long payloadId) {
			loadService.deletePayload(payloadId);
		
	}
	
}
