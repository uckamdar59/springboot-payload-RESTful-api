package com.load.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.load.entities.Payload;
import com.load.model.PayloadRequest;
import com.load.model.PayloadResponse;

public interface loadService {

	//public Page<Payload> getAllPayloads();
	public Payload getPayloadById(String id);
	public PayloadResponse createPayload(PayloadRequest payLoadRequest);
	public PayloadResponse updatePayload(String id,PayloadRequest payLoadRequest);
	public PayloadResponse deletePayload(String id);
	public Page<Payload> getAllPayloads(Optional<Integer> page, Optional<String> sortBy);
	
}
