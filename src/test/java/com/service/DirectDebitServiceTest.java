package com.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.dao.DirectDebitDao;
import com.exception.ApplicationException;
import com.form.CustomerForm;
import com.model.Customer;

@RunWith(MockitoJUnitRunner.class)
public class DirectDebitServiceTest {
	
	@InjectMocks
	DirectDebitServiceImpl directDebitServiceImpl;
	
	@InjectMocks
	Customer customer;
	
	@Mock
	DirectDebitDao directDebitDao;
		
	CustomerForm customerForm;

	@Before
	public void setUp() {
		customerForm= new CustomerForm();
		customerForm.setCustomerName("John");
		customerForm.setDirectDebitId(12345l);
		customerForm.setDirectDebitType("Recurring");
	}
	
	@Test
	public void testCancelDirectDebit_Success() throws ApplicationException {
		Customer customer =directDebitServiceImpl.cancelDirectDebit(customerForm);
		assertEquals("John", customer.getCustomerName());
		assertEquals(12345l, customer.getDirectDebitId().longValue());
		assertEquals("Recurring", customer.getDirectDebitType());
	}
	
	@Test
	public void testGetCustomerDirectDebit_Success() {
		List<Customer> restult =directDebitServiceImpl.getCustomerDebitDetails();
		assertEquals(0, restult.size());
	}
	
	@Test(expected = ApplicationException.class)
	public void testCancelDirectDebit_Invalid_Customer_Name_Null() throws ApplicationException {
		customerForm.setCustomerName(null);
		directDebitServiceImpl.cancelDirectDebit(customerForm);
	}
	
	@Test(expected = ApplicationException.class)
	public void testCancelDirectDebit_Invalid_Customer_Name_Empty() throws ApplicationException {
		customerForm.setCustomerName("");
		directDebitServiceImpl.cancelDirectDebit(customerForm);
	}
	
	@Test(expected = ApplicationException.class)
	public void testCancelDirectDebit_Invalid_Debit_Type_Null() throws ApplicationException {
		customerForm.setDirectDebitType(null);
		directDebitServiceImpl.cancelDirectDebit(customerForm);
	}
	
	@Test(expected = ApplicationException.class)
	public void testCancelDirectDebit_Invalid_Debit_Type_Empty() throws ApplicationException {
		customerForm.setDirectDebitType("");
		directDebitServiceImpl.cancelDirectDebit(customerForm);
	}
	
	@Test(expected = ApplicationException.class)
	public void testCancelDirectDebit_Invalid_Debit_Id_Null() throws ApplicationException {
		customerForm.setDirectDebitId(null);
		directDebitServiceImpl.cancelDirectDebit(customerForm);
	}

}
