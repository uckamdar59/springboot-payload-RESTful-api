package com.load.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.load.entities.Payload;
import com.load.model.PayloadRequest;

import com.load.dao.PayloadRepository;

import com.load.model.PayloadResponse;

import com.load.constantmessage.Constants;
import org.springframework.data.domain.Sort;

@Service
public class loadServiceImpl implements loadService {

	@Autowired
	PayloadRepository payloadRepository;

		
	@Override
	public Payload getPayloadById(String id) {
		
		Optional<Payload> load = payloadRepository.findById(id);
			if(load.isEmpty()) {
				return null;
			}
			return load.get();
		
	}

	@Override
	public PayloadResponse createPayload(PayloadRequest payLoadRequest) {
		// TODO Auto-generated method stub
		
		
		PayloadResponse loadResponse = new PayloadResponse();
		Payload load = new Payload();
		
		
		if(payLoadRequest.getLoadingPoint()==null) {
			loadResponse.setStatus(Constants.loadingError);
			return loadResponse;
		}
		if(payLoadRequest.getUnloadingPoint()==null) {
			loadResponse.setStatus(Constants.unloadingError);
			return loadResponse;
		}
		if(payLoadRequest.getNoOfTrucks()==0) {
			loadResponse.setStatus(Constants.noOfTrucksError);
			return loadResponse;
		}
		if(payLoadRequest.getTruckType()==null) {
			loadResponse.setStatus(Constants.truckTypeError);
			return loadResponse;
		}
		if(payLoadRequest.getProductType()==null) {
			loadResponse.setStatus(Constants.productTypeError);
			return loadResponse;
		}
		if(payLoadRequest.getWeight()==0.0) {
			loadResponse.setStatus(Constants.weightError);
			return loadResponse;
		}
		if(payLoadRequest.getDate()==null) {
			loadResponse.setStatus(Constants.dateError);
			return loadResponse;
		}
		
		
		String loadid=""+UUID.randomUUID();
		
		load.setId(loadid);
		load.setLoadingPoint(payLoadRequest.getLoadingPoint());
		load.setUnloadingPoint(payLoadRequest.getUnloadingPoint());
		load.setNoOfTrucks(payLoadRequest.getNoOfTrucks());
		load.setTruckType(payLoadRequest.getTruckType());
		load.setProductType(payLoadRequest.getProductType());
		load.setWeight(payLoadRequest.getWeight());
		load.setDate(payLoadRequest.getDate());
		load.setShipperId("shipper:"+loadid);
		if(payLoadRequest.getComment()!=null) {
			load.setComment(payLoadRequest.getComment());
		}
		
		load.setStatus(Constants.pending);
		loadResponse.setStatus(Constants.pending);
		payloadRepository.save(load);	
		return loadResponse;
		
		
	}


	@Override
	public PayloadResponse updatePayload(String id,PayloadRequest payLoadRequest) {
		// TODO Auto-generated method stub
		PayloadResponse loadResponse = new PayloadResponse();
		Payload load = new Payload();

		Optional<Payload> L = payloadRepository.findById(id);
		if(L.isPresent()) {
			load = L.get();
		}
		else {
			loadResponse.setStatus(Constants.AccountNotFoundError);
			return loadResponse;
		}

		
		if(payLoadRequest.getLoadingPoint()!=null) {
			load.setLoadingPoint(payLoadRequest.getLoadingPoint());
		}
		if(payLoadRequest.getUnloadingPoint()!=null) {
			load.setUnloadingPoint(payLoadRequest.getUnloadingPoint());
		}
		if(payLoadRequest.getProductType()!=null) {
			load.setProductType(payLoadRequest.getProductType());
		}
		if(payLoadRequest.getTruckType()!=null) {
			load.setTruckType(payLoadRequest.getTruckType());
		}
		if(payLoadRequest.getNoOfTrucks()!=0) {
			load.setNoOfTrucks(payLoadRequest.getNoOfTrucks());
		}
		if(payLoadRequest.getWeight()!=0.0) {
			load.setWeight(payLoadRequest.getWeight());
		}
		if(payLoadRequest.getComment()!=null) {
			load.setComment(payLoadRequest.getComment());
		}
		if(payLoadRequest.getStatus()!=null) {
			load.setStatus(payLoadRequest.getStatus());
		}
		if(payLoadRequest.getDate()!=null) {
			load.setDate(payLoadRequest.getDate());
		}

		
		payloadRepository.save(load);
		loadResponse.setStatus(Constants.updateSuccess);
		return loadResponse;
		
		}


	
	@Override
	public PayloadResponse deletePayload(String id) {
		
	PayloadResponse loadResponse = new PayloadResponse();
	Optional<Payload> L = payloadRepository.findById(id);
	if(L.isEmpty()) {
		loadResponse.setStatus(Constants.AccountNotFoundError);
		return loadResponse;
	}
	payloadRepository.delete(L.get());
	loadResponse.setStatus(Constants.deleteSuccess);
	return loadResponse;
	
	}


	@Override
	public Page<Payload> getAllPayloads(@RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy) {
		
		return payloadRepository.findAll(PageRequest.of(
                page.orElse(0),
                2,
                Sort.Direction.ASC, 
                sortBy.orElse("id")
        ));
	}


}
