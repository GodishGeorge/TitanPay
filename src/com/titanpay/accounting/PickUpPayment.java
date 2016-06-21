package com.titanpay.accounting;

public class PickUpPayment extends PaymentMethod{
	private Employee fullName; 
	private double amt; 
	
	public PickUpPayment(Employee fullName, double amt){
		this.fullName = fullName;
		this.amt = amt;
	}

	@Override
	public void pay() {
		System.out.println("A check for " + amt + " is waiting for " + fullName.getFullName()
			+ " at the PostMaster");
	}
}
