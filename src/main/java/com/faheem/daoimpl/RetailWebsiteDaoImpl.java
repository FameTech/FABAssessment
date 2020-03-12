package com.faheem.daoimpl;

import javax.inject.Named;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.faheem.dao.IRetailWebsiteDao;
import com.faheem.entity.CustomerDetails;
import com.faheem.retailwebsite.util.HibernateUtil;

/**
 * @author faheem
 *
 */
@Named
public class RetailWebsiteDaoImpl implements IRetailWebsiteDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.faheem.dao.IRetailWebsiteDao#registerNewCustomer(com.faheem.dto.
	 * CustomerHolder)
	 */
	@Override
	@Transactional
	public String registerNewCustomer(CustomerDetails customerHolder) {
		
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
				session.save(customerHolder);
				return "Success";
		} catch (HibernateException exception) {
			throw exception;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.faheem.dao.IRetailWebsiteDao#loadCustomerDetails(java.lang.String)
	 */
	@Override
	@Transactional
	public CustomerDetails loadCustomerDetails(String customerId) {

		CustomerDetails customer = CustomerDetails.builder().build();
		try (Session session = HibernateUtil.getSessionFactory().openSession())
		{
				Criteria criteria = session.createCriteria(CustomerDetails.class);
				criteria.add(Restrictions.eq("customerId",Integer.parseInt(customerId)));
				customer = (CustomerDetails) criteria.uniqueResult();
			
		} catch (Exception exception) {
			throw exception;
		}
		return customer;
	}

}
