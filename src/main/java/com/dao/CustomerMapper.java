package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.model.Customer;

public class CustomerMapper implements RowMapper<Customer> {
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// Just mock the data
		Customer customer = new Customer();
		customer.setCustomerName("John");
		customer.setDirectDebitId(123456l);
		customer.setDirectDebitType("Recurring");

		return customer;
	}
}