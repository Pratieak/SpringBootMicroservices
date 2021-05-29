/**
 * 
 */
package com.student.advice;

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
	public ResponseEntity<CustomError> handleDuplicateKeyException(MongoWriteException mongoWrite){
		customError.setErrorMessage("A student is already registered with same rollNumber");
		customError.setErrorCode(HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<CustomError>(customError,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<CustomError> handleEmptyInputException(EmptyInputException emptyInput){
		customError.setErrorMessage("One or more input value/s are empty");
		customError.setErrorCode(HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<CustomError>(customError,HttpStatus.BAD_REQUEST);
	}	
	
	@ExceptionHandler(NoRecordExistsException.class)
	public ResponseEntity<CustomError> handleNoRecordExistsException(NoRecordExistsException noRecordsExists){
		customError.setErrorMessage("No Record exists");
		customError.setErrorCode(HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<CustomError>(customError,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidTelephoneNumberException.class)
	public ResponseEntity<CustomError> handleDuplateKeyException(InvalidTelephoneNumberException invalidTelephoneNumber){
		customError.setErrorMessage("Invalid TelephoneNumber");
		customError.setErrorCode(HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<CustomError>(customError ,HttpStatus.BAD_REQUEST);
	}
}
