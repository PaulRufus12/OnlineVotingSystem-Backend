package org.society.exceptions;

public class WrongCredentialsException extends Exception {

	public WrongCredentialsException(String string) {
		super(string);
		
	}
	
	private static final long serialVersionUID = 1L;
	
	public WrongCredentialsException() {
		super();
	}

}
