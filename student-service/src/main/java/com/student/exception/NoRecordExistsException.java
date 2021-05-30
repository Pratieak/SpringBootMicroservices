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
public class NoRecordExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoRecordExistsException(String string ) {
		super(string);
	}

	public NoRecordExistsException() {
		super();
	}
}
