package com.jobapp.exception;

/**
 * @author PrasannaJ
 *
 */
public class DescriptionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DescriptionNotFoundException() {
		super();
	}

	public DescriptionNotFoundException(String message) {
		super(message);
	}

}
