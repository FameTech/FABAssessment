package com.faheem.retailwebsite.util;

import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author faheem
 *
 */
public class CommonUtils {

	public static int getDiffYears(Date first, Date last)
	{
		Period period = Period.between(first.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate(), last.toInstant()
				.atZone(ZoneId.systemDefault())
				.toLocalDate());
		return period.getYears();
	}
}
