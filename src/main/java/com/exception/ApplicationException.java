package com.exception;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = -4714548331889091155L;
	private String message;

	public ApplicationException(String exceptionMsg) {
		this.message = exceptionMsg;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
