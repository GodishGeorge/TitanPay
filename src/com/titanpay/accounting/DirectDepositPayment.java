package com.titanpay.accounting;

public class DirectDepositPayment extends PaymentMethod{
	private BankAccount directDeposit;
	private double amt;
	
	public DirectDepositPayment(BankAccount directDeposit, double amt){
		this.directDeposit = directDeposit;
		this.amt = amt;
	}
	
	@Override
	public void pay() {
		System.out.println(directDeposit.deposit(amt));
	}
}
