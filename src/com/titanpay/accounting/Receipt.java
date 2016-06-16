package com.titanpay.accounting;

import java.util.Date;

public class Receipt {
	Date date;
	double saleAmt;
	
	public Receipt(Date date, double saleAmt)
	{
		this.date = date;
		this.saleAmt = saleAmt;
	}
}
