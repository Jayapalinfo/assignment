package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.exception.ApplicationException;
import com.model.Customer;

/**
 * Implementation class for the interface DirectDebitDao.
 * 
 * @author Jayapal
 *
 */
public class DirectDebitDaoImpl implements DirectDebitDao {

	JdbcTemplate jdbcTemplate;
	DataSource dataSource;

	private static final Logger LOGGER = Logger.getLogger(DirectDebitDaoImpl.class);

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Get Customer debit details
	 * 
	 * @return
	 */
	@Override
	public List<Customer> getCustomerDebitDetails() {
		return new ArrayList<>();
	}

	/**
	 * Cancel the customer debit detail by updating the status to cancel
	 * 
	 * @param customer
	 */
	@Override
	public void cancelDirectDebit(Customer customer) throws ApplicationException {

		String query = "update Customer set status=? where directDebitId=?";
		try {
			Object[] args = new Object[] { customer.getStatus(), customer.getDirectDebitId() };

			int out = jdbcTemplate.update(query, args);
			if (out != 0) {
				LOGGER.info("Direct debit updated with id=" + customer.getDirectDebitId());
			} else {
				LOGGER.info("No direct debit found with id=" + customer.getDirectDebitId());
			}
		} catch (DataAccessException exception) {
			LOGGER.error(exception.getMessage());
			throw new ApplicationException(exception.getMessage());
		}

	}

}
