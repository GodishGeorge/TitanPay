package com.titanpay.accounting;

public class Salaried_Employee {
	
	int employeeId;
	String firstName;
	String lastName;
	double salary;
	double commissionRate;
	double weeklyDues;
	
	public Salaried_Employee(int employeeId, String firstName, String lastName, 
			double salary, double commissionRate, double weeklyDues)
	{
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.commissionRate = commissionRate;
		this.weeklyDues = weeklyDues;
	}
	
	public String getFullName()
	{
		return lastName + ", " + firstName;
	}
}
