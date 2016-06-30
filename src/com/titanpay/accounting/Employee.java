package com.titanpay.accounting;

public abstract class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private double unionDues;
	private PaymentMethod methodOfPay;
	
	public Employee(int employeeId, String firstName, String lastName, 
			double unionDues)
	{
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.unionDues = unionDues;
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

	public double getUnionDues() {
		return unionDues;
	}

	public void setUnionDues(double unionDues) {
		this.unionDues = unionDues;
	}
	
	public void setPaymentMethod(PaymentMethod method)
	{
		this.methodOfPay = method;
	}
	
	public PaymentMethod getMethodOfPay(){
		return this.methodOfPay;
	}
}
