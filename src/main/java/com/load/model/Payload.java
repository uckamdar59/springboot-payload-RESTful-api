package com.load.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



import com.fasterxml.uuid.Generators;
import java.util.UUID;


@Entity
@Table(name = "payloads")
public class Payload {

	
	
	
	  UUID randomUUID =  Generators.randomBasedGenerator().generate();
      
	
      
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getLoadId() {
		return loadId;
	}

	public void setLoadId(long loadId) {
		this.loadId = loadId;
	}

	@Column(nullable = false)
	public String getLoadingPoint() {
		return loadingPoint;
	}

	public void setLoadingPoint(String loadingPoint) {
		this.loadingPoint = loadingPoint;
	}

	@Column(nullable = false)
	public String getUnloadingPoint() {
		return unloadingPoint;
	}

	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}

	@Column(nullable = false)
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	@Column(nullable = false)
	public String getTruckType() {
		return truckType;
	}

	public void setTruckType(String truckType) {
		this.truckType = truckType;
	}

	@Column(nullable = false)
	public int getNoOfTrucks() {
		return noOfTrucks;
	}

	public void setNoOfTrucks(int noOfTrucks) {
		this.noOfTrucks = noOfTrucks;
	}

	@Column(nullable = false)
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(nullable = false)
	public String getShipperId() {
		return randomUUID.toString();
	}

	public void setShipperId(String shipperId) {
		this.shipperId = randomUUID.toString();
	}

	@Column(nullable = false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public Payload( String loadingPoint,
			String unloadingPoint, String productType, String truckType, int noOfTrucks, double weight, String comment,
			String shipperId, Date date) {
		super();
		
		  System.out.println("Random UUID :"+randomUUID.toString());
	      
	      System.out.println("UUID version : "+randomUUID.version());
		
		
		this.loadingPoint = loadingPoint;
		this.unloadingPoint = unloadingPoint;
		this.productType = productType;
		this.truckType = truckType;
		this.noOfTrucks = noOfTrucks;
		this.weight = weight;
		this.comment = comment;
		this.shipperId = randomUUID.toString();
		this.date = date;
	}

	private long loadId;
	
	
	private String loadingPoint;
	private String unloadingPoint;
	private String productType;
	private String truckType;
	private int noOfTrucks;
	private double weight;
	private String comment;
	private String shipperId;
	private Date date;
	
	
	
	
	
	public Payload() {
		
	}
	
	


	@Override
	public String toString() {
		return "Payload [loadId=" + loadId + ",  loadingPoint=" + loadingPoint + ", unloadingPoint=" + unloadingPoint + ", productType="
				+ productType + ", truckType=" + truckType + ", noOfTrucks=" + noOfTrucks + ", weight=" + weight
				+ ", comment=" + comment + ", shipperId=" + shipperId + ", date=" + date + "]";
	}
	
}
