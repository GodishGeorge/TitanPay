package com.titanpay.accounting;

public class MailPayment extends PaymentMethod{
	private String fullName;
	private Address address;
	private double amt;
	
	public MailPayment(String fullName, Address address, double amt)
	{
		this.fullName = fullName;
		this.address = address;
		this.amt = amt;
	}

	@Override
	public void pay() 
	{
		System.out.println("Mailing a check to " + fullName + " for "
				+ amt + " to " + address);
	}
}
