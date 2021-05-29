/**
 * 
 */
package com.student.service;

import java.util.List;

import com.student.model.Student;

/**
 * @author Prateek Maurya
 *
 */


public interface StudentService {

	public void registerStudent(Student student);
	
	public Student getStudentDetails(String rollNumber);
	
	public void updateStudentDetails(Student student);
	
	public List<Student> getAllStudentDetails();
	
	public void deleteStudent(String rollNumber);
	
}
