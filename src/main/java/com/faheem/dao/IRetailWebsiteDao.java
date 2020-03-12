package com.faheem.dao;

import com.faheem.entity.CustomerDetails;

/**
 * @author faheem
 *
 */
public interface IRetailWebsiteDao {

	CustomerDetails loadCustomerDetails(String customerId);

	String registerNewCustomer(CustomerDetails customerHolder);
	
	
}
