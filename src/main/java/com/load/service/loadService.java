package com.load.service;

import java.util.List;


import com.load.entities.Payload;
import com.load.model.PayloadRequest;
import com.load.model.PayloadResponse;

public interface loadService {

	
	//public List<Payload> getAllPayloads();
	public List<Payload> getPayloadById(Long payloadId);
	public PayloadResponse createPayload(PayloadRequest payLoadRequest);
	public PayloadResponse updatePayload(PayloadRequest payLoadRequest);
	public void deletePayload(Long loadId);
	
	
	


}
