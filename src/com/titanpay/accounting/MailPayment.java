package com.titanpay.accounting;

public class MailPayment extends PaymentMethod{
	private Employee fullName;
	private Address address;
	private double amt;
	
	public MailPayment(Employee fullName, Address address, double amt)
	{
		this.fullName = fullName;
		this.address = address;
		this.amt = amt;
	}

	@Override
	public void pay() 
	{
		System.out.println("Mailing a check to " + fullName.getFullName() + " for "
				+ amt + " to " + address.getAddress());
	}
}
