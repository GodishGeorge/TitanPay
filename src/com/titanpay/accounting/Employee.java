package com.titanpay.accounting;

public abstract class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private double weeklyDues;
	
	public Employee(int employeeId, String firstName, String lastName, 
			double weeklyDues)
	{
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.weeklyDues = weeklyDues;
	}
	
	public String getFullName()
	{
		return lastName + ", " + firstName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getWeeklyDues() {
		return weeklyDues;
	}

	public void setWeeklyDues(double weeklyDues) {
		this.weeklyDues = weeklyDues;
	}
}
