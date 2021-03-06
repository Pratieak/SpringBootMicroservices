/**
 * 
 */
package com.student.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

/**
 * @author Prateek Maurya
 *
 */

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{

	Student findByEnrollmentNumber(String enrollmentNumber);

	void deleteByEnrollmentNumber(String enrollmentNumber);

}
