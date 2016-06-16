package com.titanpay.accounting;
import java.util.Date;

public class TimeCard {
	private Date date;
	private double startTime = new Date().getTime();
	private double endTime = new Date().getTime();
	
	public TimeCard(Date date, double startTime, double endTime)
	{
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public double calculateDailyPay(double rate)
	{
		double hours = endTime - startTime;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	public double getEndTime() {
		return endTime;
	}

	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}
}
