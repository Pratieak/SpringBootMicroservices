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

/**
 * @author Prateek Maurya
 *
 */

@RequestMapping("/student")
@RestController
public class Controller {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/register")
	public ResponseEntity<Object> register(@RequestBody Student student){
		studentService.registerStudent(student);
		return new ResponseEntity<>(HttpStatus.CREATED);		
	}
	
	@GetMapping("/getStudent/{enrollmentNumber}")
	public ResponseEntity<Student> getStudent(@PathVariable String enrollmentNumber){
		return new ResponseEntity<Student>(studentService.getStudentDetails(enrollmentNumber),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public  ResponseEntity<Object> update(@RequestBody Student student){
		studentService.updateStudentDetails(student);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Student>> getAllStudents(){
		return new ResponseEntity<List<Student>>( studentService.getAllStudentDetails(),HttpStatus.OK);
	}

	@DeleteMapping("/deleteStudent/{enrollmentNumber}")
	public ResponseEntity<Object> deleteStudent(@PathVariable String enrollmentNumber){
		studentService.deleteStudent(enrollmentNumber);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
