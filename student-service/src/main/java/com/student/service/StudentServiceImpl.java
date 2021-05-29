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
				|| student.getSectionName().isEmpty() || student.getRollNumber().isEmpty()
				|| student.getPhoneNumber().isEmpty() || student.getGuardianNumber().isEmpty())
			throw new EmptyInputException("601", "One or more input value/s are empty");
		if( student.getPhoneNumber().length()!=10 || student.getGuardianNumber().length()!=10 )
			throw new InvalidTelephoneNumberException("406","Invalid TelephoneNumber");
		studentRepository.insert(student);
	}

	@Override
	public Student getStudentDetails(String rollNumber) {	
		if(studentRepository.findByRollNumber(rollNumber)==null)
			throw new NoRecordExistsException("404", "Student Record Not Found");
		return studentRepository.findByRollNumber(rollNumber);
	}

	@Override
	public void updateStudentDetails(Student student) {
		Student s = studentRepository.findByRollNumber(student.getRollNumber());
		s.setEmailId(student.getEmailId());
		s.setPhoneNumber(student.getPhoneNumber());
		s.setGuardianNumber(student.getGuardianNumber());
		s.setAddress(student.getAddress());
		studentRepository.save(s);
	}

	@Override
	public List<Student> getAllStudentDetails() {	
		if(studentRepository.findAll().isEmpty())
			throw new NoRecordExistsException("404", "Student Record Not Found");
		return studentRepository.findAll();
	}

	@Override
	public void deleteStudent(String rollNumber) {
		if(studentRepository.findByRollNumber(rollNumber)==null)
			throw new NoRecordExistsException("404", "Student Record Not Found");
		studentRepository.deleteByRollNumber(rollNumber);
	}

}
