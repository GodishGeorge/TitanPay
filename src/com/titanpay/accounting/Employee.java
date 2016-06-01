package com.titanpay.accounting;

public class Employee {
	int employeeId;
	String firstName;
	String lastName;
	double hourlyRate;
	double weeklyDues;
	
	public Employee(int employeeId, String firstName, String lastName, 
			double hourlyRate, double weeklyDues)
	{
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hourlyRate = hourlyRate;
		this.weeklyDues = weeklyDues;
	}
	
	public String getFullName() 
	{
		return lastName + ", " + firstName;
	}
}
