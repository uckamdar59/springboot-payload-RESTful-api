package com.load.service;

import com.load.entities.Payload;
import com.load.model.PayloadRequest;
import com.load.model.PayloadResponse;

public interface loadService {

	public Payload getPayloadById(String id);
	public PayloadResponse createPayload(PayloadRequest payLoadRequest);
	public PayloadResponse updatePayload(String id,PayloadRequest payLoadRequest);
	public PayloadResponse deletePayload(String id);
	
}
