/**
 * 
 */
package com.student.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mongodb.MongoWriteException;
import com.student.exception.EmptyInputException;
import com.student.exception.InvalidTelephoneNumberException;
import com.student.exception.NoRecordExistsException;
import com.student.model.CustomError;

/**
 * @author Prateek Maurya
 *
 */

@ControllerAdvice
public class StudentControllerAdvice {
	
	CustomError customError = new CustomError();
	
	@ExceptionHandler(MongoWriteException.class)
	public ResponseEntity<CustomError> handleDuplicateKeyException(MongoWriteException e){
		customError.setErrorMessage(e.getMessage());
		customError.setTimestamp(LocalDateTime.now());
		customError.setStatus((HttpStatus.NOT_FOUND.value()));
		customError.setErrorCode(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<CustomError>(customError,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<CustomError> handleEmptyInputException(EmptyInputException e){
		customError.setErrorMessage("One or more input value/s are empty");
		customError.setTimestamp(LocalDateTime.now());
		customError.setStatus((HttpStatus.NOT_FOUND.value()));
		customError.setErrorCode(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<CustomError>(customError,HttpStatus.BAD_REQUEST);
	}	
	
	@ExceptionHandler(NoRecordExistsException.class)
	public ResponseEntity<CustomError> handleNoRecordExistsException(NoRecordExistsException e){
		customError.setErrorMessage("No Record Exists");
		customError.setTimestamp(LocalDateTime.now());
		customError.setStatus((HttpStatus.NOT_FOUND.value()));
		customError.setErrorCode(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<CustomError>(customError,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidTelephoneNumberException.class)
	public ResponseEntity<CustomError> handleInvalidTelephoneNumberException(InvalidTelephoneNumberException e){
		customError.setErrorMessage("Invalid TelephoneNumber");
		customError.setTimestamp(LocalDateTime.now());
		customError.setStatus((HttpStatus.NOT_FOUND.value()));
		customError.setErrorCode(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<CustomError>(customError ,HttpStatus.BAD_REQUEST);
	}
}
