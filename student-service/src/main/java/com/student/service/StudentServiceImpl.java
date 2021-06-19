/**
 * 
 */
package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoWriteException;
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
