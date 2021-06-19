package com.student.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	
	@NotBlank(message ="classNumber is mandatory")
	private String classNumber;
	
	@NotBlank(message ="sectionName is mandatory")
	private String sectionName;
	
	@NotBlank(message ="firstName is mandatory")
	private String firstName;
	
	@NotBlank(message ="lastName is mandatory")
	private String lastName;
	
	@NotBlank(message ="gender is mandatory")
	private String gender;

	@Email(message ="emailId is not valid")
	private String emailId;
	
	@Size(min = 10, max = 10, message 
		      = "Phone Number must contain only 10 digits")
	private String phoneNumber;
	
	@NotBlank(message ="guardianName is mandatory")
	private String guardianName;
	
	@Size(min = 10, max = 10, message 
		      = "Phone Number must contain only 10 digits")
	private String guardianNumber;
	
	@NotBlank(message ="address is mandatory")
	private String address;

}
