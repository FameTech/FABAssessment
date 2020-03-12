package com.faheem.service;

import org.springframework.stereotype.Service;

import com.faheem.billing.BillingProcess;
import com.faheem.common.RetailConstants;
import com.faheem.common.UserType;
import com.faheem.model.Bill;
import com.faheem.model.User;

@Service
public class RetailService {
	
	private Bill bill;
	
	public Bill generateBill(User user) {
		BillingProcess billingProcess = new BillingProcess(); 	
		switch (user.getUserType()) {

		case EMPLOYEE:
			bill = billingProcess.generateBill(UserType.EMPLOYEE.getDiscountPercent(), RetailConstants.AMOUNT_BASEED_DISCOUNT_VALUE,user.getItemList());
			break;
			
		case AFFILIATED:
			bill = billingProcess.generateBill(UserType.AFFILIATED.getDiscountPercent(), RetailConstants.AMOUNT_BASEED_DISCOUNT_VALUE, user.getItemList());
			break;
		
		case VALUED_CUSTOMER:
			bill = billingProcess.generateBill(UserType.VALUED_CUSTOMER.getDiscountPercent(), RetailConstants.AMOUNT_BASEED_DISCOUNT_VALUE, user.getItemList());
			break;
		}
		
		return bill;
	}
	
	

}
