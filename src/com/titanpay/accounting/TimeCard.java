package com.titanpay.accounting;
import java.util.Date;

public class TimeCard {
	String date;
	long startTime = new Date().getTime();
	long endTime = new Date().getTime();
	
	public TimeCard(String date, long startTime, long endTime)
	{
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public double calculateDailyPay(double rate)
	{
		long hours = endTime - startTime;
		double hoursWorked = ((hours / (1000 * 60 * 60)) % 24); 
		double overTime = hoursWorked - 8;
		double overTimePay = (rate * 1.5) * overTime;
		
		if (hoursWorked > 8)
		{
			double totalPay = (hoursWorked * rate) + overTimePay;
			return totalPay;
		}
		else
		{
			double totalPay = hoursWorked * rate;
			return totalPay;
		}
	}
}
