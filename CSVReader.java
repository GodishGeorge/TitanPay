package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.titanpay.accounting.Address;
import com.titanpay.accounting.BankAccount;
import com.titanpay.accounting.DirectDepositPayment;
import com.titanpay.accounting.Employee;
import com.titanpay.accounting.HourlyEmployee;
import com.titanpay.accounting.MailPayment;
import com.titanpay.accounting.PickUpPayment;
import com.titanpay.accounting.Receipt;
import com.titanpay.accounting.SalariedEmployee;
import com.titanpay.accounting.TimeCard;

public class CSVReader {

	public static List<TimeCard> parseTimeCards(String csvFile, int employeeId) {
		List<TimeCard> parsedTimeCards = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
			String headers = reader.readLine();
			String line = null;
			int csvEmployeeId;
			double startTime;
			double endTime;
			Date date = null;

			while ((line = reader.readLine()) != null) {
				String[] timeData = line.split("\\s*,\\s*");
				csvEmployeeId = Integer.parseInt(timeData[0]);
				if (csvEmployeeId == employeeId) {
					String time1 = timeData[1];
					if (time1.length() <= 3)
						time1 = "0" + time1;
					String time2 = timeData[2];
					if (time2.length() <= 3)
						time2 = "0" + time2;
					startTime = Double.parseDouble(timeData[3] + "-" + time1);
					endTime = Double.parseDouble(timeData[3] + "-" + time2);
					TimeCard timeCard = new TimeCard(date, startTime, endTime);
					parsedTimeCards.add(timeCard);
				}
			}
		}
	catch (FileNotFoundException e){
		e.printStackTrace();
	}
		catch (IOException e){
			e.printStackTrace();
		}
		return parsedTimeCards;
	}

public static List<Receipt> parseReceipts(String csvFile, int employeeId) {
	List<Receipt> parsedReceipts = new ArrayList<>();
	try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		String headers = reader.readLine();
		String line = null;
		int csvEmployeeId;
		double saleAmt;
		Date date = null;

		while ((line = reader.readLine()) != null) {
			String[] receiptData = line.split("\\s*,\\s*");
			csvEmployeeId = Integer.parseInt(receiptData[0]);
			
			if (csvEmployeeId == employeeId){
				saleAmt = Double.parseDouble(receiptData[3])*Double.parseDouble(receiptData[4]);			
				Receipt receipt = new Receipt(date, saleAmt);
				parsedReceipts.add(receipt);
			}
		}
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

	return parsedReceipts;
	
}

public static List<HourlyEmployee> parseHourlyEmployees(String csvFile) {
	List<HourlyEmployee> parsedEmployees = new ArrayList<>();
	try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		String headers = reader.readLine();
		String line = null;
		int csvEmployeeId;
		double hourlyRate;
		double unionDues;
		

		while ((line = reader.readLine()) != null) {
			String[] employeeData = line.split("\\s*,\\s*");
			csvEmployeeId = Integer.parseInt(employeeData[0]);
			hourlyRate = Double.parseDouble(employeeData[3]);

			if (employeeData[4].contains("-"))
				employeeData[4] = "0";
			unionDues = Double.parseDouble(employeeData[4]);
			Address addressInfo = new Address("123 Elm Street", "Tampa", "FL", 33626);
			BankAccount bankInfo = new BankAccount("Suntrust", 123456789, 987654321);
			String fullName = employeeData[1] + " " + employeeData[2];
			if (employeeData[5].contains("DD")){
	
				HourlyEmployee employee = new HourlyEmployee(csvEmployeeId, employeeData[2], 
						employeeData[1], unionDues, hourlyRate, new DirectDepositPayment(bankInfo));			
				parsedEmployees.add(employee);

			}
			else if (employeeData[5].contains("PU")){
				
				HourlyEmployee employee = new HourlyEmployee(csvEmployeeId, employeeData[2], 
						employeeData[1], unionDues, hourlyRate, new PickUpPayment(fullName, 0));	
				parsedEmployees.add(employee);

			}
			else if (employeeData[5].contains("MA")){
				HourlyEmployee employee = new HourlyEmployee(csvEmployeeId, employeeData[2], 
						employeeData[1], unionDues, hourlyRate, new MailPayment(fullName, addressInfo, 0));
				parsedEmployees.add(employee);

			}
		}
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

	return parsedEmployees;

}

public static List<SalariedEmployee> parseSalariedEmployees(String csvFile) {
	List<SalariedEmployee> parsedEmployees = new ArrayList<>();
	try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
		String headers = reader.readLine();
		String line = null;
		int csvEmployeeId;
		double salary;
		double commissionRate; 
		double unionDues;

		while ((line = reader.readLine()) != null) {
			// parse out the data
			String[] employeeData = line.split("\\s*,\\s*");
			csvEmployeeId = Integer.parseInt(employeeData[0]);
			commissionRate = Double.parseDouble(employeeData[4]);
			salary = Double.parseDouble(employeeData[3]);
			if (employeeData[5].contains("-"))
				employeeData[5] = "0";
			unionDues = Double.parseDouble(employeeData[5]);
			String name = employeeData[1]+" "+employeeData[2];
			if (employeeData[4].contains("-"))
				employeeData[4] = "0";
			unionDues = Double.parseDouble(employeeData[4]);
			Address addressInfo = new Address("123 Elm Street", "Tampa", "FL", 33626);
			BankAccount bankInfo = new BankAccount("Suntrust", 123456789, 987654321);
			String fullName = employeeData[1] + " " + employeeData[2];
			if (employeeData[5].contains("DD")){
	
				SalariedEmployee employee = new SalariedEmployee(csvEmployeeId, employeeData[2], 
						employeeData[1], unionDues, commissionRate, salary, new DirectDepositPayment(bankInfo));			
				parsedEmployees.add(employee);

			}
			else if (employeeData[5].contains("PU")){
				
				SalariedEmployee employee = new SalariedEmployee(csvEmployeeId, employeeData[2], 
						employeeData[1], unionDues, commissionRate, salary, new PickUpPayment(fullName, 0));	
				parsedEmployees.add(employee);

			}
			else if (employeeData[5].contains("MA")){
				SalariedEmployee employee = new SalariedEmployee(csvEmployeeId, employeeData[2], 
						employeeData[1], unionDues, commissionRate, salary, new MailPayment(fullName, addressInfo, 0));
				parsedEmployees.add(employee);

			}
		}
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}

	return parsedEmployees;

}}
