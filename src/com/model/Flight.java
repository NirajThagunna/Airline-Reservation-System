package com.model;

// All the data for the flight to the database
public class Flight {
	
	// member of flight
	private String flightNo;
	private String flightName;
	private String from;
	private String to;
	private String date;
	private String time;
	private double travelDuration;
	private String airportName;
	private double ticketPrice;
	
	
	public Flight(String flightNo, String flightName, String from, String to, String date, String time, double travelDuration,
			String airportName, double ticketPrice) {
		this.flightNo = flightNo;
		this.flightName = flightName;
		this.from = from;
		this.to = to;
		this.date = date;
		this.time = time;
		this.travelDuration = travelDuration;
		this.airportName = airportName;
		this.ticketPrice = ticketPrice;
	}
	
	public String getFlightNo() {
		return flightNo;
	}
	
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	public String getFlightName() {
		return flightName;
	}
	
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	
	public String getFrom() {
		return from;
	}
	
	public void setFrom(String from) {
		this.from = from;
	}
	
	public String getTo() {
		return to;
	}
	
	public void setTo(String to) {
		this.to = to;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public double getTravelDuration() {
		return travelDuration;
	}
	
	public void setTravelDuration(double travelDuration) {
		this.travelDuration = travelDuration;
	}
	
	public String getAirportName() {
		return airportName;
	}
	
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	
	public double getTicketPrice() {
		return ticketPrice;
	}
	
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
