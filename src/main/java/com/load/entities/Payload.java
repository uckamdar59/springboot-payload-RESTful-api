package com.load.entities;


import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "payloads")
@Data
public class Payload {

	
	@Id
	private String id;
	
	private String loadingPoint;
	private String unloadingPoint;
	private String productType;
	private String truckType;
	private int noOfTrucks;
	private double weight;
	private String comment;
	private String shipperId;
	private Date date;
	private String status;
	
	}
