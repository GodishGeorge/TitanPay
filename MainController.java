package application;


import java.util.Date;
import java.util.List;

import com.titanpay.accounting.HourlyEmployee;
import com.titanpay.accounting.Receipt;
import com.titanpay.accounting.SalariedEmployee;
import com.titanpay.accounting.TimeCard;

public class MainController {
	private static List<HourlyEmployee> hourEmployee;
	private static List<SalariedEmployee> salaryEmployee;
	
	
	public static void processPayroll(int employeeId, Date startDate, Date endDate){
		hourEmployee = CSVReader.parseHourlyEmployees("hourly_employees.csv");
		for (HourlyEmployee employee : hourEmployee){
			List<TimeCard> hourTimecard = CSVReader.parseTimeCards("timecards.csv", employee.getEmployeeId());
			employee.setTimeCards(hourTimecard);
		}
	
	
	salaryEmployee = CSVReader.parseSalariedEmployees("salaried_employees.csv");
	for (SalariedEmployee employee : salaryEmployee) {
		List<Receipt> salaryReceipt = CSVReader.parseReceipts("receipts.csv", employee.getEmployeeId());
		employee.setReceipts(salaryReceipt);
		
	}
	
	for (HourlyEmployee employee : hourEmployee){
		employee.pay(employee.getEmployeeId(), startDate, endDate);
	}
	
	for (SalariedEmployee employee : salaryEmployee) {
		employee.pay(employee.getEmployeeId(), startDate, endDate );
	}
}}
