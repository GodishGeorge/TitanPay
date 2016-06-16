package com.titanpay.accounting;

public class MailPayment extends PaymentMethod{
	private Employee fullName;
	private Address address;
	
	

	
	public String mailPayment(double amt)
	{
		return "Mailing a check to " + fullName.getFullName() + " for "
				+ amt + " to " + address.getAddress();
	}


	@Override
	public void pay() 
	{
	
	}
}
