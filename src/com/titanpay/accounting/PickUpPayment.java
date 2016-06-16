package com.titanpay.accounting;

public class PickUpPayment extends PaymentMethod{
	private Employee fullName; 
	
	public String pickUpPayment()
	{
		return "A check for $800.00 is waiting for " + fullName.getFullName()
			+ " at the PostMaster";
	}

	@Override
	public void pay() {
		
	}
}
