package com.titanpay.accounting;

import java.util.ArrayList;
import java.util.Date;

public class HourlyEmployee extends Employee implements Payable {
	private ArrayList<TimeCard> timeCards;
	private double hourlyRate;
	
	public HourlyEmployee(int employeeId, String firstName, String lastName, 
			double weeklyDues, double hourlyRate)
	{
		super(employeeId, firstName, lastName, weeklyDues);
		this.hourlyRate = hourlyRate;
		timeCards = new ArrayList<TimeCard>();
	} 
	
	public void clockIn()
	{
		timeCards.add(new TimeCard(new Date(), new Date().getTime(), 0));		
	}
	
	public void clockOut()
	{
		Date currentDt = new Date();
		for (TimeCard t : timeCards)
		{
			if (t.getDate().getMonth() == currentDt.getMonth()
					&& t.getDate().getDay() == currentDt.getDay()
					&& t.getDate().getYear() == currentDt.getYear())
			{
				double endTime = new Date().getTime();
				t.setEndTime(endTime);
			}
		}
	}
	
	public double pay(Date startDate, Date endDate)
	{
		double pay = 0.0;
		for (TimeCard t : timeCards)
		{
			if (t.getDate().after(startDate) && 
			t.getDate().before(endDate))
			{
				pay += t.calculateDailyPay(hourlyRate);
			}
		}
		this.getMethodOfPay().pay();
		return pay;
	}
}
