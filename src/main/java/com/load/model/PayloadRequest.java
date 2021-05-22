package com.load.model;

import java.util.Date;
import java.util.UUID;

import lombok.Data;

@Data
public class PayloadRequest {

	private String loadingPoint;
	private String unloadingPoint;
	private String productType;
	private String truckType;
	private int noOfTrucks;
	private double weight;
	private String comment;
	private UUID shipperId;
	private Date date;
	
}
