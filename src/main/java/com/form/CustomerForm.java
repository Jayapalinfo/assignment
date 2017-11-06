package com.form;

/**
 * Customer form
 * 
 * @author Jayapal
 *
 */
public class CustomerForm {
	private String customerName;
	private Long directDebitId;
	private String directDebitType;

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

}
