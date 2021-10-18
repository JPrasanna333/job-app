package com.jobapp.exception;

/**
 * @author PrasannaJ
 *
 */
public class JobNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JobNotFoundException() {
		super();
	}

	public JobNotFoundException(String message) {
		super(message);
	}

}
