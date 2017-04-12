package com.od;


import java.sql.Date;

public class ODSaveParkRoomsModel {
	
	int parkId;
	String facilityTypeCode;
	String facilityType;
	String rommTypeDescription;
	String maxPeople;
	String maxAdults;
	String maxKids;
	String maxQty;
	String regularPrice;
	Date dateAdded;
	
	
	
	public ODSaveParkRoomsModel(String rommTypeDescription, String maxPeople, String maxKids, String maxAdults, String maxQty, String regularPrice, Date dateAdded, int parkId, String facilityTypeCode) {
		super();
		this.facilityTypeCode=facilityTypeCode;
		this.rommTypeDescription=rommTypeDescription;
		this.maxPeople=maxPeople;
		this.maxAdults=maxAdults;
		this.maxKids=maxKids;
		this.maxQty=maxQty;
		this.regularPrice=regularPrice;
		this.dateAdded=dateAdded;
		this.parkId=parkId;
	}
	
	
	
	public int getParkId() {
		return parkId;
	}



	public void setParkId(int parkId) {
		this.parkId = parkId;
	}

	public String getFacilityTypeCode() {
		return facilityTypeCode;
	}



	public void setFacilityTypeCode(String facilityTypeCode) {
		this.facilityTypeCode = facilityTypeCode;
	}



	public String getFacilityType() {
		return facilityType;
	}



	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}



	public String getRommTypeDescription() {
		return rommTypeDescription;
	}


	public void setRommTypeDescription(String rommTypeDescription) {
		this.rommTypeDescription = rommTypeDescription;
	}


	public String getMaxPeople() {
		return maxPeople;
	}


	public void setMaxPeople(String maxPeople) {
		this.maxPeople = maxPeople;
	}


	public String getMaxAdults() {
		return maxAdults;
	}


	public void setMaxAdults(String maxAdults) {
		this.maxAdults = maxAdults;
	}


	public String getMaxKids() {
		return maxKids;
	}


	public void setMaxKids(String maxKids) {
		this.maxKids = maxKids;
	}


	public String getMaxQty() {
		return maxQty;
	}


	public void setMaxQty(String maxQty) {
		this.maxQty = maxQty;
	}


	public String getRegularPrice() {
		return regularPrice;
	}


	public void setRegularPrice(String regularPrice) {
		this.regularPrice = regularPrice;
	}


	


	public Date getDateAdded() {
		return dateAdded;
	}


	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}


	public ODSaveParkRoomsModel(){
		
	}

}
