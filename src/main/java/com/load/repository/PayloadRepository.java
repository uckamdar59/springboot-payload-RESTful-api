package com.load.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.load.model.Payload;



@Repository
public interface PayloadRepository extends JpaRepository<Payload, Long>{

}
