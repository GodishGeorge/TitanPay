package com.titanpay.accounting;

import java.util.ArrayList;
import java.util.Date;

public class HourlyEmployee extends Employee implements Payable {
	ArrayList<TimeCard> timeCards = new ArrayList<TimeCard>();
	private double hourlyRate;
	
	public HourlyEmployee(int employeeId, String firstName, String lastName, 
			double weeklyDues, double hourlyRate)
	{
		super(employeeId, firstName, lastName, weeklyDues);
		this.hourlyRate = hourlyRate;
	} 
	
	public void clockIn()
	{
		timeCards.add(new TimeCard(new Date(), new Date().getTime(), 0));		
	}
	
	public void clockOut()
	{
		for (TimeCard t : timeCards)
		{
			if (t.getDate() == t.getDate())
			{
				double endTime = new Date().getTime();
				t.setEndTime(endTime);
			}
		}
	}
	
	public double pay(Date startDate, Date endDate)
	{
		
		for (TimeCard t : timeCards)
		{
			if (t.getDate().after(startDate) == startDate) && 
			(t.getDate().before(endDate) == endDate)
			{
				double pay = t.calculateDailyPay(hourlyRate);
			}
		}
	}
}
