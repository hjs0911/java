package kr.hkit.mybatis_dev.mappers;

import java.util.List;
import java.util.Map;

import kr.hkit.mybatis_dev.dto.Student;

public interface StudentMapper {
	List<Student> findAllStudents();
	Student findStudentById(int studId);
	int insertStudentAutoIncrement(Student student);
	int updateStudent(Student student);
	int deleteStudent(int studId);
	
	List<Student> findAllStudentForResultMap();
	Student findStudentByIdFroResultMap(int studId);
	
	List<Map<String, Object>> findAllStudentsForHashMap();
	Map<String, Object> findStudentByIdForHashMap(int studId);
	
	Student findStudentByIdForResultMapExtend(int studId);
	
	Student selectStudentWithAdderssResultOneToOne(int studId);
	
	Student findStudentWithAddressOneToOneNested(int studId);
}
