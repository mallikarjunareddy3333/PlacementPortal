package com.placement.portal.exceptions;

public class MyResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public MyResourceNotFoundException() {
		super();
	}

	public MyResourceNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public MyResourceNotFoundException(final String message) {
		super(message);
	}

	public MyResourceNotFoundException(final Throwable cause) {
		super(cause);
	}

}
