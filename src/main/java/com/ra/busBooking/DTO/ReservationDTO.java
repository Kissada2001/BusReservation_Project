package com.ra.busBooking.DTO;

public class ReservationDTO {

	private String filterDate;
	private String to;
	private String from;
	private String BusName;
	private String time;
	private Double price; 
	private int id;
	
	
	//AND Getters , Setters

	public String getFilterDate() {
		return filterDate;
	}

	public void setFilterDate(String filterDate) {
		this.filterDate = filterDate;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getBusName() {
		return BusName;
	}

	public void setBusName(String busName) {
		BusName = busName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
