package kr.hkit.mybatis;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.hkit.dto.Student;
import kr.hkit.mybatis.services.StudentService;

public class StudentServiceTest {
	private static StudentService studentService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = StudentService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;
	}
	
	/*@Test
	public void testtFindStudentbyId(){
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
		System.out.println(student);
	}
	
	@Test
	public void testFindAllStudents() {
		List<Student> lists = studentService.findAllStudents();
		Assert.assertNotNull(lists);
		for(Student std : lists){
			System.out.println(std);
		}
	}
	
	@Test
	public void testInsertStudent(){
		Student student = new Student();
		student.setStudId(8);
		student.setName("성민갓");
		student.setEmail("ann@naver.com");
		student.setDob(new Date());
		
		int result = studentService.createStudentForInterface(student);
		Assert.assertSame(1, result);
	}*/
	
	@Test
	public void testFindAllStudentForInterface(){
		List<Student> lists = studentService.findAllStudentInterfaceForMixing();
		Assert.assertNotNull(lists);
		System.out.println("\ntestFindAllStudentForInterface() : ");
		for(Student std : lists){
			System.out.println(std);
		}
		System.out.println();
	}
	
	@Test
	public void testFindStudentByIdForInterface(){
		Student student = studentService.findStudentByIdInterfaceForMixing(1);
		Assert.assertNotNull(student);
		System.out.println("\ntestFindStudentByIdForInterface() : \n" + student);
	}
	
	@Test
	public void testCreateStudentForInterface(){
		Student student = new Student();
		student.setStudId(10);
		student.setName("슈퍼울트라성민갓!");
		student.setEmail("god@naver.com");
		student.setDob(new Date());
		
		int result = studentService.createStudentInterfaceForMixing(student);
		Assert.assertSame(1, result);
	}

}
