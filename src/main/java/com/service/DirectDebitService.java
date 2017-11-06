package com.service;

import java.util.List;

import com.exception.ApplicationException;
import com.form.CustomerForm;
import com.model.Customer;

public interface DirectDebitService {

	/**
	 * Interface to get Customer details
	 * 
	 * @return
	 */
	List<Customer> getCustomerDebitDetails();

	/**
	 * Interface to cancel Customer direct debit details
	 * 
	 * @param customer
	 * @return
	 */
	Customer cancelDirectDebit(CustomerForm customerForm) throws ApplicationException;

}
