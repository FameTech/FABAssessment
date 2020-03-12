package com.faheem.process.factory;

import com.faheem.common.RetailConstants;
import com.faheem.process.discount.AmountBasedDiscountProcess;
import com.faheem.process.discount.DiscountProcess;
import com.faheem.process.discount.PercentageBasedDiscountProcess;

public class DiscountFactory {
	private DiscountFactory() {}
	public static DiscountProcess getInstance(String discountType, double value) {
		if(discountType.equals(RetailConstants.PERCENT_BASED)) {
			return  new PercentageBasedDiscountProcess(value);
		}else {
			return new AmountBasedDiscountProcess(value);
			
		}
	}

}
