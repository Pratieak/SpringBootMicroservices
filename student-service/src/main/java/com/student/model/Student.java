package com.student.model;

import org.springframework.data.annotation.Id;

import lombok.Data;

/**
 * @author Prateek Maurya
 *
 */

@Data
public class Student {
	
	@Id
	private String enrollmentNumber;
	private String classNumber;
	private String sectionName;
	private String firstName;
	private String lastName;
	private String gender;
	private String emailId;
	private String phoneNumber;
	private String guardianName;
	private String guardianNumber;
	private String address;

}
