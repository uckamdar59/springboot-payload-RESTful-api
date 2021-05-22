package com.load.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.load.entities.Payload;
import com.load.model.PayloadRequest;

import com.load.dao.PayloadRepository;

import com.load.model.PayloadResponse;


@Service
public class loadServiceImpl implements loadService {

	@Autowired
	PayloadRepository payloadRepository;
	
	//@Override
//	public List<Payload> getAllPayloads() {
//		return payloadRepository.findAll();
//	}

	
	
	@Override
	public List<Payload> getPayloadById(Long payloadId) {
		if(payloadId!=null)
			 return payloadRepository.findAllById(payloadId);
		return payloadRepository.findByStatus("pending");
		
	}

	
	public PayloadResponse createPayload(PayloadRequest payLoadRequest) {
		// TODO Auto-generated method stub
		
		
		PayloadResponse loadResponse = new PayloadResponse();
		Payload load = new Payload();
		
		load.setShipperId(UUID.randomUUID());
		if(payLoadRequest.getComment()!=null) {
			load.setComment(payLoadRequest.getComment());
		}
		load.setUnloadingPoint(payLoadRequest.getUnloadingPoint());
		load.setLoadingPoint(payLoadRequest.getLoadingPoint());
		load.setNoOfTrucks(payLoadRequest.getNoOfTrucks());
		load.setTruckType(payLoadRequest.getTruckType());
		load.setProductType(payLoadRequest.getProductType());
		load.setWeight(payLoadRequest.getWeight());
		load.setDate(payLoadRequest.getDate());
		
		load.setStatus("pending");
		loadResponse.setStatus("pending");
		payloadRepository.save(load);	
		return loadResponse;
		
		
	}



	public PayloadResponse updatePayload(PayloadRequest payLoadRequest) {
		// TODO Auto-generated method stub
		PayloadResponse loadResponse = new PayloadResponse();
		 payloadRepository.save(payLoadRequest);
		// return 
		return loadResponse;
		
	}


	
	@Override
	public void deletePayload(Long loadId) {
		// TODO Auto-generated method stub
	payloadRepository.deleteById(loadId);
//	payloadRepository.findById(loadId);
		}

}
