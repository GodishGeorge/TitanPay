package com.titanpay.accounting;

import java.util.Date;

public interface Payable {
	
	
	double pay(int employeeId, Date startDate, Date endDate);
	
}
  