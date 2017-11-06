package com.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DirectDebitDao;
import com.exception.ApplicationException;
import com.form.CustomerForm;
import com.model.Customer;

/**
 * Implementation class for the ineterface DirectDebitService
 * @author Jayapal
 *
 */
public class DirectDebitServiceImpl implements DirectDebitService {

	@Autowired
	DirectDebitDao directDebitDao;

	private static final Logger LOGGER = Logger.getLogger(DirectDebitServiceImpl.class);

	@Override
	public List<Customer> getCustomerDebitDetails() {
		return new ArrayList<>();
	}

	/**
	 * Interface to cancel Customer direct debit details
	 * 
	 * @param customerForm
	 * @return
	 */
	@Override
	public Customer cancelDirectDebit(CustomerForm customerForm) throws ApplicationException {
		LOGGER.info("Inside cancelDebit... ");
		Customer customer = null;
		String customerName = customerForm.getCustomerName();
		Long directDebitId = customerForm.getDirectDebitId();
		String directDebitType = customerForm.getDirectDebitType();
		if (null != customerName && !customerName.isEmpty() && null != directDebitId && null != directDebitType
				&& !directDebitType.isEmpty()) {
			customer = new Customer(customerName, directDebitId, directDebitType, "Cancel");
			directDebitDao.cancelDirectDebit(customer);

		} else {
			throw new ApplicationException("Customer Name, Debit id and debit types are required!");
		}

		return customer;

	}

}
