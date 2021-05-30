/**
 * 
 */
package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * @author Prateek Maurya
 *
 */

@RequestMapping("/student")
@RestController
public class Controller {
	
	@Autowired
	StudentService studentService;
	
	
	@Operation(summary = "This method registers the details of an individual student", 
			   responses = { @ApiResponse( responseCode = "203", description = "Successful Operation", content = @Content),
					         @ApiResponse( responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })	    
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody Student student){
		studentService.registerStudent(student);
		return new ResponseEntity<>(HttpStatus.CREATED);		
	}
	
	
	@Operation(summary = "This method retrieves the registered details of an individual student using rollNumber",
			   responses = { @ApiResponse( responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
					         @ApiResponse( responseCode = "404", description = "Not found", content = @Content),
					         @ApiResponse( responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })	    
	@GetMapping("/getStudent/{enrollmentNumber}")
	public ResponseEntity<Student> getStudent(@PathVariable String enrollmentNumber){
		return new ResponseEntity<Student>(studentService.getStudentDetails(enrollmentNumber),HttpStatus.OK);
	}
	
	
	@Operation(	summary = "This method upodates the registered details of an individual student",
			   	responses = { @ApiResponse( responseCode = "201", description = "Successful Operation", content = @Content),
				             @ApiResponse( responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })	    
	@PutMapping("/update")
	public  ResponseEntity<Object> update(@RequestBody Student student){
		studentService.updateStudentDetails(student);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@Operation(	summary = "This method retrieves the registered details all the registered students",
			   	responses = { @ApiResponse( responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
					   		 @ApiResponse( responseCode = "404", description = "Not found", content = @Content),
					   		 @ApiResponse( responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true)))})	    
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>( studentService.getAllStudentDetails(),HttpStatus.OK);
	}

	
	@Operation(	summary = "This method deletes the registered details of an individual student using rollNumber",
				responses = { @ApiResponse( responseCode = "200", description = "Successful Operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
			   		 		  @ApiResponse( responseCode = "404", description = "Not found", content = @Content),
			   		 		  @ApiResponse( responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true)))})	    
	@DeleteMapping("/deleteStudent/{enrollmentNumber}")
	public ResponseEntity<Object> deleteStudent(@PathVariable String enrollmentNumber){
		studentService.deleteStudent(enrollmentNumber);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
