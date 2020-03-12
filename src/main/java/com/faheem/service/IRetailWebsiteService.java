package com.faheem.service;

import com.faheem.entity.CustomerDetails;

/**
 * @author faheem
 *
 */
public interface IRetailWebsiteService {
	
    String registerNewCustomer(CustomerDetails customerHolder);
	
    CustomerDetails loadCustomerDetails(String customerId); 

}
