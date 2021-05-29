/**
 * 
 */
package com.student.model;

import org.springframework.http.HttpStatus;

import lombok.Data;

/**
 * @author Prateek Maurya
 *
 */

@Data
public class CustomError {
	
	private String errorCode;
	private String errorMessage;
	
}
