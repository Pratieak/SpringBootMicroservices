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
public class EmptyInputException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmptyInputException(String string ) {
		super(string);
	}
	
	public EmptyInputException() {
		super();
	}

}
