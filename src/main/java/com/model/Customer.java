package com.model;

/**
 * Model class which holds the customer details
 * 
 * @author Jayapal
 *
 */
public class Customer {

	private String customerName;
	private Long directDebitId;
	private String directDebitType;
	private String status;

	public Customer() {
		// Default constructor
	}

	public Customer(String customerName, Long directDebitId, String directDebitType, String status) {
		this.customerName = customerName;
		this.directDebitId = directDebitId;
		this.directDebitType = directDebitType;
		this.status = status;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the directDebitId
	 */
	public Long getDirectDebitId() {
		return directDebitId;
	}

	/**
	 * @param directDebitId
	 *            the directDebitId to set
	 */
	public void setDirectDebitId(Long directDebitId) {
		this.directDebitId = directDebitId;
	}

	/**
	 * @return the directDebitType
	 */
	public String getDirectDebitType() {
		return directDebitType;
	}

	/**
	 * @param directDebitType
	 *            the directDebitType to set
	 */
	public void setDirectDebitType(String directDebitType) {
		this.directDebitType = directDebitType;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}