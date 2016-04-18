package kr.hkit.jdbc;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.hkit.dto.Student;
import kr.hkit.jdbc.services.StudentService;

public class StudentServiceTest {
	private static StudentService studentService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = StudentService.getIntance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;
	}

	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
		System.out.println(student);
	}
	
	@Test
	public void testCreateStudentDuplicate(){
		Student std = new Student();
		std.setStudId(1);
		std.setName("안성민");
		std.setEmail("asm@naver.com");
		std.setDob(new Date());
		
		int result = studentService.createStudent(std);
		Assert.assertEquals(0, result);

	}
	
	@Test
	public void testCreateStudent(){
		Student std = new Student();
		std.setStudId(4);
		std.setName("배준열");
		std.setEmail("bjy@naver.com");
		std.setDob(new Date());
		
		int result = studentService.createStudent(std);
		Assert.assertEquals(1, result);
	}

}
