package com.titanpay.accounting;

import java.util.ArrayList;
import java.util.Date;

public class SalariedEmployee extends Employee implements Payable {
	ArrayList<Receipt> receipt = new ArrayList<Receipt>();
	private double salary;
	private double commissionRate;

	
	public SalariedEmployee(int employeeId, String firstName, String lastName, 
			double salary, double commissionRate, double weeklyDues)
	{
		super (employeeId, firstName, lastName, weeklyDues);
		this.salary = salary;
		this.commissionRate = commissionRate;
	}
	
	public void makeSale(double amt)
	{
		receipt.add(new Receipt(new Date(), 0));
	}
	
	public double pay(Date startDate, Date endDate)
	{
		for (Receipt r : receipt)
		{
			if (r.getDate().after(startDate) == startDate) && 
			(r.getDate().before(endDate) == endDate)
			{
				double pay = r.makeSale(commissionRate);
			}
		}
	}
}
