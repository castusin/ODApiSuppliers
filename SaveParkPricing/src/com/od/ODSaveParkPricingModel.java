package com.od;


import java.sql.Date;

public class ODSaveParkPricingModel {
	
	int parkId;
	String roomTypeCode;
	Date fromDate;
	Date toDate;
	float currentPrice;
	
	
	public ODSaveParkPricingModel(String roomTypeCode, Date fromDate, Date toDate, float currentPrice, int parkId) {
		super();
		
		this.roomTypeCode=roomTypeCode;
		this.fromDate=fromDate;
		this.toDate=toDate;
		this.currentPrice=currentPrice;
		this.parkId=parkId;
		
	}
	
	public int getParkId() {
		return parkId;
	}

	public void setParkId(int parkId) {
		this.parkId = parkId;
	}

	public String getRoomTypeCode() {
		return roomTypeCode;
	}

	public void setRoomTypeCode(String roomTypeCode) {
		this.roomTypeCode = roomTypeCode;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public float getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}

	public ODSaveParkPricingModel(){
		
	}

}
