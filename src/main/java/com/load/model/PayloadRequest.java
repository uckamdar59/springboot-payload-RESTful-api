package com.load.model;

import java.util.Date;

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
	private String shipperId;
	private Date date;
	private String status;
	
}
