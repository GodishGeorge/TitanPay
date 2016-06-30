package com.titanpay.accounting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalariedEmployee extends Employee implements Payable {
	private ArrayList<Receipt> receipt;
	private double salary;
	private double commissionRate;

	
	public SalariedEmployee(int employeeId, String firstName, String lastName, 
			double salary, double commissionRate, double unionDues, PaymentMethod method)
	{
		super (employeeId, firstName, lastName, unionDues);
		this.salary = salary;
		this.commissionRate = commissionRate;
		receipt = new ArrayList<Receipt>();
	}
	
	public void makeSale(double amt)
	{
		receipt.add(new Receipt(new Date(), 0));
	}
	
	public double pay(int employeeId, Date startDate, Date endDate)
	{
		double pay = 0.0;
		for (Receipt r : receipt)
		{
			if (r.getDate().after(startDate) && 
			r.getDate().before(endDate))
			{	
				pay += r.calculateCommission(commissionRate);
			}
		}
		this.getMethodOfPay().pay();
		return pay;
	}

	public void setReceipts(List<Receipt> salaryReceipt) {
		this.receipt = (ArrayList<Receipt>) receipt;
		
	}
}
