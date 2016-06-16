package com.titanpay.accounting;

import java.util.Date;

public interface Payable {
	
	
	double pay(Date startDate, Date endDate);
	
}
  