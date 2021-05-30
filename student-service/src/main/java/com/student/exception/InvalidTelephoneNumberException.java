/**
 * 
 */
package com.student.exception;

import org.springframework.stereotype.Component;

/**
 * @author Prateek Maurya
 *
 */

@Component
public class InvalidTelephoneNumberException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidTelephoneNumberException(String string ) {
		super(string);
	}
	
	public InvalidTelephoneNumberException() {
		super();
	}

}
