package com.model;

public class Payment {

	private String cardNo;
	private String cardHolderName;
	private int month;
	private int year;
	private String cvvNo;
	private double amtToPay;
	
	public Payment(String cardNo, String cardHolderName, int month, int year, String cvvNo, double amtToPay) {
		this.cardNo = cardNo;
		this.cardHolderName = cardHolderName;
		this.month = month;
		this.year = year;
		this.cvvNo = cvvNo;
		this.amtToPay = amtToPay;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCvvNo() {
		return cvvNo;
	}

	public void setCvvNo(String cvvNo) {
		this.cvvNo = cvvNo;
	}

	public double getAmtToPay() {
		return amtToPay;
	}

	public void setAmtToPay(double amtToPay) {
		this.amtToPay = amtToPay;
	}
}
