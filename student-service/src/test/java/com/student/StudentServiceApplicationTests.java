package com.student;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

import com.student.model.Student;

@SpringBootTest
class StudentServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	private TestRestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testRegisterStudentDetailAPI() throws Exception {
		Student student = new Student();
		student.setFirstName("TestName");
		student.setLastName("LastTestName");
		student.setEnrollmentNumber("Test02");
		student.setAddress("TestAddress");
		student.setClassNumber("TestClass");
		student.setEmailId("TestMail");
		student.setGender("Test");
		student.setGuardianName("TestGuardian");
		student.setSectionName("TestSection");
		student.setPhoneNumber("0000000000");
		student.setGuardianNumber("9999999999");
		restTemplate.postForEntity("http://localhost:8080/student/register", student, null);
		assertThat(this.restTemplate.getForObject("http://localhost:8080/student/getStudent/Test02",
				String.class)).contains("TestName");
	}
	
	@Test
	public void testRetrieveStudentDetailAPI() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/student/getStudent/Test02",
				String.class)).contains("TestName");
	}
	
	@Test
	public void testRetrieveAllStudentDetailAPI() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:8080/student/getAll",
				String.class)).contains("TestName");
	}
	

	@Test
	public void testupdateStudentDetailAPI() throws Exception {
		Student student = new Student();
		student.setFirstName("TestName");
		student.setLastName("LastTestName");
		student.setEnrollmentNumber("Test02");
		student.setAddress("TestAddress");
		student.setClassNumber("TestClass");
		student.setEmailId("TestMail");
		student.setGender("Test");
		student.setGuardianName("TestGuardian");
		student.setSectionName("TestSection");
		student.setPhoneNumber("3333333333");
		student.setGuardianNumber("8888888888");
		HttpEntity<Student> entity = new HttpEntity<Student>(student);
		restTemplate.exchange(new URI("http://localhost:8080/student/update"), HttpMethod.PUT, entity, String.class);
		assertThat(this.restTemplate.getForObject("http://localhost:8080/student/getStudent/Test02",
				String.class)).contains("8888888888");
	}
	
	@Test
	public void testDeleteStudentDetailAPI() throws Exception {
		restTemplate.delete(new URI("http://localhost:8080/student/deleteStudent/Test01"));
		assertThat(this.restTemplate.getForObject("http://localhost:8080/student/getStudent/Test01",
				String.class)).contains("No Record Exists");
	}
}
