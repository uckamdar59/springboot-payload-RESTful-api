package com.load.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.load.model.Payload;
import com.load.repository.PayloadRepository;
import com.load.exception.ResourceNotFoundException;



@RestController
public class PayloadController {

	
	@Autowired
	private PayloadRepository payloadRepository;

	@GetMapping("/load")
	public List<Payload> getAllPayloads() {
		return payloadRepository.findAll();
	}
	
	
	
	
	@GetMapping("/load/{loadId}")
	public ResponseEntity<Payload> getPayloadById(@PathVariable(value = "loadId") Long payloadId)
			throws ResourceNotFoundException {
		Payload Payload = payloadRepository.findById(payloadId)
				.orElseThrow(() -> new ResourceNotFoundException("Payload details not found for this id :: " + payloadId));
		return ResponseEntity.ok().body(Payload);
	
	}
	
	
	
	@PostMapping("/load")
	public Map<String, Boolean> createPayload(@Valid @RequestBody Payload payload) {
		payloadRepository.save(payload);
		Map<String, Boolean> response = new HashMap<>();
		response.put("loads details added successfully", Boolean.TRUE);
		return response;
		
		
	}
	
	
	
	@PutMapping("/load/{loadId}")
	public ResponseEntity<Payload> updatePayload(@PathVariable(value = "loadId") Long payloadId,
			@Valid @RequestBody Payload payloadDetails) throws ResourceNotFoundException {
		Payload payload = payloadRepository.findById(payloadId)
				.orElseThrow(() -> new ResourceNotFoundException("Payload details not found for this id :: " + payloadId));

		
		payload.setLoadingPoint(payloadDetails.getLoadingPoint());
		payload.setUnloadingPoint(payloadDetails.getUnloadingPoint());
		payload.setProductType(payloadDetails.getProductType());
		payload.setTruckType(payloadDetails.getTruckType());
		payload.setNoOfTrucks(payloadDetails.getNoOfTrucks());
		payload.setWeight(payloadDetails.getWeight());
		payload.setComment(payloadDetails.getComment());
		payload.setDate(payloadDetails.getDate());
		
		
		
		final Payload updatedPayload = payloadRepository.save(payload);
		return ResponseEntity.ok(updatedPayload);
	}
	
	
	
	@DeleteMapping("/load/{loadId}")
	public Map<String, Boolean> deletePayload(@PathVariable(value = "loadId") Long payloadId)
			throws ResourceNotFoundException {
		Payload payload = payloadRepository.findById(payloadId)
				.orElseThrow(() -> new ResourceNotFoundException("Payload details not found for this id :: " + payloadId));

		payloadRepository.delete(payload);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
