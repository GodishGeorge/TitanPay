package com.titanpay.accounting;

public class BankAccount {
	String bankName;
	int routingNumber;
	int accountId;
	
	public BankAccount(String bankName, int routingNumber, int accountId)
	{
		this.bankName = bankName;
		this.routingNumber = routingNumber;
		this.accountId = accountId;
	}
	
	public String deposit(double amt)
	{
		return "Depositing $" + amt + " in " + bankName + "Account Number: "
				+ accountId + " using Routing Number: " + routingNumber;
	}
}
