package com.jobapp.exception;

/**
 * @author PrasannaJ
 *
 */
public class SkillNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SkillNotFoundException() {
		super();
	}

	public SkillNotFoundException(String message) {
		super(message);
	}

}
