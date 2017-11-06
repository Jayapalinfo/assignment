package com.dao;

import java.util.List;

import com.exception.ApplicationException;
import com.model.Customer;

/**
 * Interface containing methods to perform insert, get, update and delete
 * functionality in DB
 * 
 * @author Jayapal
 *
 */
public interface DirectDebitDao {

	/**
	 * Interface to get Customer details
	 * 
	 * @return
	 */
	List<Customer> getCustomerDebitDetails();

	/**
	 * Interface to cancel Customer debit details
	 * 
	 * @param customer
	 */
	void cancelDirectDebit(Customer customer) throws ApplicationException;

}
