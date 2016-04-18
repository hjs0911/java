package kr.hkit.mybatis.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.hkit.dto.Student;

public interface StudentMapper {
	@Select("select stud_id as studId, name, email, dob from student")
	List<Student> findAllStudentForInterface();
	
	@Select("select stud_id as studId, name, email, dob "
			+ "from student "
			+ "where stud_id = #{studId}")
	Student findStudentByIdForInterface(int id);
	
	@Insert("insert into student (stud_id, name, email, dob) "
		+ "values(#{studId}, #{name}, #{email}, #{dob})")
	int createStudentForInterface(Student student);
	
	Student findStudentByIdForMixing(int studId);
	List<Student> findAllStudentsForMixing();
	int insertStudentForMixing(Student student);
}
