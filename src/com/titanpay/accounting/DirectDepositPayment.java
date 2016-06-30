package com.titanpay.accounting;

public class DirectDepositPayment extends PaymentMethod{
	private BankAccount bankAccount;
	private double amt;
	
	public DirectDepositPayment(BankAccount bankAccount){
		this.bankAccount = bankAccount;
		
	}
	
	@Override
	public void pay() {
		System.out.println(bankAccount.deposit(amt));
	}
}
