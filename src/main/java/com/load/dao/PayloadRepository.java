package com.load.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.load.entities.Payload;
import com.load.model.PayloadRequest;
import com.load.model.PayloadResponse;



@Repository
public interface PayloadRepository extends JpaRepository<Payload, Long>{

	public List<Payload> findByStatus(String status);
	
	//public List<Payload> findById(Long loadId);
	//public List<Payload> findById(Long loadId);
	public List<Payload> findAllById(Long loadId);

	public PayloadResponse save(PayloadRequest payLoadRequest);
	
	
	
}
