package com.dao;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.exception.ApplicationException;
import com.form.CustomerForm;
import com.model.Customer;
import com.service.DirectDebitServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DirectDebitDaoImplTest {

	@InjectMocks
	DirectDebitDaoImpl directDebitDaoImpl;
	@Mock
	JdbcTemplate jdbcTemplate;
	
	@Mock
	DirectDebitDao directDebitDao;
	Customer customer;

	@Before
	public void setUp() {
		customer= new Customer();
		customer.setCustomerName("John");
		customer.setDirectDebitId(12345l);
		customer.setDirectDebitType("Recurring");
	}
	
	@Test
	public void testCancelDirectDebit_Success() throws ApplicationException {
		directDebitDaoImpl.cancelDirectDebit(customer);
		assertEquals("John", customer.getCustomerName());
		assertEquals(12345l, customer.getDirectDebitId().longValue());
		assertEquals("Recurring", customer.getDirectDebitType());
	}
	
	@Test
	public void testCancelDirectDebit_Exception() throws ApplicationException {
		Mockito.doThrow(new RuntimeException()).when(jdbcTemplate).update(Mockito.anyString());
		directDebitDaoImpl.cancelDirectDebit(customer);
		assertEquals("John", customer.getCustomerName());
		assertEquals(12345l, customer.getDirectDebitId().longValue());
		assertEquals("Recurring", customer.getDirectDebitType());
	}
}
