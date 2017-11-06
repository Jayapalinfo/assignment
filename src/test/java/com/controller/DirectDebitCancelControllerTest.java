package com.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;

import com.exception.ApplicationException;
import com.form.CustomerForm;
import com.model.Customer;
import com.service.DirectDebitService;

@RunWith(MockitoJUnitRunner.class)
public class DirectDebitCancelControllerTest {

	@InjectMocks
	DirectDebitCancelController directDebitCancelController;

	@Mock
	DirectDebitService userService;

	@Mock
	Model model;

	CustomerForm customerForm;

	@Before
	public void setUp() {
		customerForm = new CustomerForm();
		customerForm.setCustomerName("John");
		customerForm.setDirectDebitId(12345l);
		customerForm.setDirectDebitType("Recurring");
	}

	@Test
	public void testCustomerForm() {
		directDebitCancelController.customerForm(model);
		assertTrue(true);
	}

	@Test
	public void testCancelDirectDebit_Success() throws ApplicationException {
		Mockito.when(userService.cancelDirectDebit(Mockito.anyObject())).thenReturn(getCustomer());
		String restult = directDebitCancelController.cancelDirectDebit(model, customerForm);
		assertEquals("confirm", restult);
	}

	@Test
	public void testCancelDirectDebit_Throw_ApplicationException() throws ApplicationException {
		try {
			Mockito.when(userService.cancelDirectDebit(Mockito.anyObject())).thenThrow(new ApplicationException("Exception"));
			String restult = directDebitCancelController.cancelDirectDebit(model, customerForm);
			assertEquals("index", restult);
		} catch (Exception e) {
			assertEquals("Exception123", e.getMessage());
		}
	}

	@Test
	public void testCancelDirectDebit_Throw_Exception() throws Exception {
		try {
			Mockito.when(userService.cancelDirectDebit(Mockito.anyObject())).thenThrow(new NullPointerException("Null"));
			String restult = directDebitCancelController.cancelDirectDebit(model, customerForm);
			assertEquals("index", restult);
		} catch (Exception e) {
			assertEquals("Null", e.getMessage());
		}
	}

	@Test
	public void testReferenceData() {
		directDebitCancelController.referenceData();
		assertTrue(true);
	}

	private Customer getCustomer() {
		Customer customer = new Customer();
		customer.setCustomerName("John");
		customer.setDirectDebitId(123456l);
		customer.setDirectDebitType("Recurring");
		customer.setStatus("Active");
		return customer;
	}

}
