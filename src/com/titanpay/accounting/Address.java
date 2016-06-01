package com.titanpay.accounting;

public class Address {
	String streetAddress;
	String city;
	String state;
	int zipCode;
	
	public Address(String streetAddress, String city, String state, int zipCode)
	{
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public String getAddres()
	{
		return streetAddress + " " + city + ", " + state + " " + zipCode;
	}
}
