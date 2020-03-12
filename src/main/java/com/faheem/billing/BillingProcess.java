package com.faheem.billing;

import java.util.List;

import com.faheem.common.ItemType;
import com.faheem.common.RetailConstants;
import com.faheem.model.Bill;
import com.faheem.model.Item;
import com.faheem.process.factory.DiscountFactory;

public class BillingProcess {
	
	private Bill bill;
	
	public  Bill generateBill(double percentDiscount, double discountValue, List<Item> itemList) {
		bill = calculateBillAmount(itemList);
		double percentBasedDiscount = DiscountFactory.getInstance(RetailConstants.PERCENT_BASED, percentDiscount).applyDiscount(bill.getNonGroceriesAmount());
		double totalAmountAfterDiscount = (bill.getGroceriesAmount() + bill.getNonGroceriesAmount())- percentBasedDiscount;
		double amountBasedDiscount = DiscountFactory.getInstance(RetailConstants.AMOUNT_BASED, discountValue).applyDiscount(totalAmountAfterDiscount);
		bill.setPayableAmount(totalAmountAfterDiscount - amountBasedDiscount);
		bill.setDiscount(percentBasedDiscount + amountBasedDiscount);
		return bill;
	}
	
		private Bill calculateBillAmount(List<Item> itemList) {
			bill = new Bill();
			if(itemList != null) {
				double nonGroceriesTotalAmount = 0.0;
				double groceriesTotalAmount = 0.0;
				for(Item item: itemList) {
					if(item.getItemType() == ItemType.NON_GROCERY) {
						nonGroceriesTotalAmount += item.getPrice();	
					}else {
						groceriesTotalAmount += item.getPrice();
					}
				}
				bill.setGroceriesAmount(groceriesTotalAmount);
				bill.setNonGroceriesAmount(nonGroceriesTotalAmount);
			}
			return bill;
		}



}
