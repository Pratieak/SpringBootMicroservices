/**
 * 
 */
package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoWriteException;
import com.student.exception.EmptyInputException;
import com.student.exception.InvalidTelephoneNumberException;
import com.student.exception.NoRecordExistsException;
import com.student.model.Student;
import com.student.repo.StudentRepository;

/**
 * @author Prateek Maurya
 *
 */

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public void registerStudent(Student student) throws MongoWriteException{
		if(student.getFirstName().isEmpty() || student.getClassNumber().isEmpty() 
				|| student.getSectionName().isEmpty() || student.getEnrollmentNumber().isEmpty()
				|| student.getPhoneNumber().isEmpty() || student.getGuardianNumber().isEmpty())
			throw new EmptyInputException("601 One or more input value/s are empty");
		if( student.getPhoneNumber().length()!=10 || student.getGuardianNumber().length()!=10 )
			throw new InvalidTelephoneNumberException("406 Invalid TelephoneNumber");
		studentRepository.insert(student);
	}

	@Override
	public Student getStudentDetails(String enrollmentNumber) {	
		if(studentRepository.findByEnrollmentNumber(enrollmentNumber)==null)
			throw new NoRecordExistsException("404 Student Record Not Found");
		return studentRepository.findByEnrollmentNumber(enrollmentNumber);
	}

	@Override
	public void updateStudentDetails(Student student) {
		Student s = studentRepository.findByEnrollmentNumber(student.getEnrollmentNumber());
		if(s!= null) {
			if(student.getPhoneNumber().isEmpty() || student.getEmailId().isEmpty()
			   || student.getAddress().isEmpty() || student.getGuardianNumber().isEmpty())
				throw new EmptyInputException("601 One or more input value/s are empty");
			s.setEmailId(student.getEmailId());
			s.setPhoneNumber(student.getPhoneNumber());
			s.setGuardianNumber(student.getGuardianNumber());
			s.setAddress(student.getAddress());
			studentRepository.save(s);
		} else throw new NoRecordExistsException("404 Student Record Not Found");
	}

	@Override
	public List<Student> getAllStudentDetails() {	
		if(studentRepository.findAll().isEmpty())
			throw new NoRecordExistsException("404 No Record Found");
		return studentRepository.findAll();
	}

	@Override
	public void deleteStudent(String enrollmentNumber) {
		if(studentRepository.findByEnrollmentNumber(enrollmentNumber)==null)
			throw new NoRecordExistsException("404 No Record Found");
		studentRepository.deleteByEnrollmentNumber(enrollmentNumber);
	}

}
