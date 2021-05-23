package com.load.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.load.entities.Payload;



@Repository
public interface PayloadRepository extends JpaRepository<Payload, String>{

	}
