package kr.hkit.mybatis_dev;

import kr.hkit.mybatis_dev.dto.Student;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.hkit.mybatis_dev.services.StudentService;

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

/*	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
		System.out.println("testFindStudentById " + student);
	}*/
	
/*	@Test
	public void testInsertStudent(){
		Student student = new Student();
		student.setName("김태희");
		student.setEmail("test3@test3.co.kr");
		student.setPhone(new PhoneNumber("123-456-7890"));
		student.setDob(new Date());
		
		int result = studentService.insertStudentAutoIncrement(student);
		System.out.printf("testInsertStudent %s : result : %d%n", student, result);
		Assert.assertSame(1, result);
		Assert.assertSame(3, student.getStudId());
	}*/
	
/*	@Test
	public void testUpdateStudent(){
		Student student = new Student();
		student.setStudId(1);
		student.setName("Timothy");
		student.setEmail("test@test.co.kr");
		student.setPhone(new PhoneNumber("987-654-3211"));
		student.setDob(new Date());
		
		int result = studentService.updateStudent(student);
		System.out.printf("testUpdateStudent %s : result : %d%n", student, result);
		Assert.assertSame(1, result);
		
		student.setEmail("timothy@gmail.com");
		student.setPhone(new PhoneNumber("123-123-1234"));
		student.setDob(new GregorianCalendar(1988, 04, 25).getTime());
		result = studentService.updateStudent(student);
		System.out.printf("testUpdateStudent %s : result : %d%n", student, result);
		Assert.assertSame(1, result);
	}*/
	
/*	@Test
	public void testDeleteStudent(){
		int deleteStudent = studentService.deleteStudent(6);
		System.out.printf("testUpdateStudent : result %d%n", deleteStudent);
		Assert.assertSame(1, deleteStudent);
	}*/
	
	/*@Test
	public void testFindAllStudents(){
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		System.out.println("testFindAllStudents");
		for(Student str : students){
			Assert.assertNotNull(str);
			System.out.println(str);
		}
	}*/
	
/*	@Test
	public void testFindAllStudentForResultMap(){
		List<Student> students = studentService.findAllStudentForResultMap();
		Assert.assertNotNull(students);
		System.out.println("testFindAllStudentForResultMap");
		for(Student str : students){
			System.out.println(str);
		}
	}
	
	@Test
	public void testFindStudentByIdFroResultMap(){
		Student student = studentService.findStudentByIdFroResultMap(1);
		Assert.assertNotNull(student);
		System.out.println("testFindStudentByIdFroResultMap " + student);
	}*/
	
/*	@Test
	public void testFindAllStudentsForHashMap(){
		List<Map<String, Object>> studentsMap = studentService.findAllStudentsForHashMap();
		System.out.println("findAllStudentsForHashMap size " + studentsMap.size());
		for(Map<String, Object> studMap : studentsMap){
			System.out.printf("stud_id : %s%n", studMap.get("STUD_ID"));
			System.out.printf("naem : %s%n", studMap.get("NAME"));
			System.out.printf("email : %s%n", studMap.get("EMAIL"));
			System.out.printf("phone : %s%n", studMap.get("PHONE"));
			System.out.printf("dob : %s%n", studMap.get("DOB"));
		}
		for(Entry<String, Object> entry : studentsMap.entrySet()){
			System.out.printf("key : %s - value : %s %n", entry.getKey(), entry.getValue());
		}
	}*/
	
/*	@Test
	public void testFindStudentByIdForHashMap(){
		Map<String, Object> studMap = studentService.findStudentByIdForHashMap(3);
		Assert.assertNotNull(studMap);
		System.out.println("findStudentByIdForHashMap");
		for(Entry<String, Object> entry : studMap.entrySet()){
			System.out.printf("key : %s - value : %s %n", entry.getKey(), entry.getValue());
		}
	}*/
	
/*	@Test
	public void testFindStudentByIdForResultMapExtend(){
		Student student = studentService.findStudentByIdForResultMapExtend(1);
		Assert.assertNotNull(student);
		System.out.println("findStudentByIdForResultMapExtend " + student);
	}*/
	
/*	@Test
	public void testSelectStudentWithAdderssResultOneToOne(){
		Student student = studentService.selectStudentWithAdderssResultOneToOne(1);
		Assert.assertNotNull(student);
		System.out.println("studentWithAdderssResultOneToOne " + student);
	}*/
	
	@Test
	public void testFindStudentWithAddressOneToOneNested(){
		Student student = studentService.findStudentWithAddressOneToOneNested(1);
		Assert.assertNotNull(student);
		System.out.println("studentWithAddressOneToOneNested " + student);
	}

}
