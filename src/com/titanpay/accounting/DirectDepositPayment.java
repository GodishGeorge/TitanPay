package com.titanpay.accounting;

public class DirectDepositPayment extends PaymentMethod{
	private BankAccount directDeposit;
	
	public String directDepositPayment()
	{
		return directDeposit.deposit(0);
	}

	@Override
	public void pay() {
	
	}
}
