/**
 * 
 */
package com.student.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * @author Prateek Maurya
 *
 */

@Data
public class CustomError {
	
	private HttpStatus errorCode;
	private String errorMessage;
	int status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
	LocalDateTime timestamp;
	
}
