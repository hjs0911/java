package kr.hkit.mybatis_dev.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.hkit.mybatis_dev.dto.Student;
import kr.hkit.mybatis_dev.mappers.StudentMapper;
import kr.hkit.mybatis_dev.util.MybatisSqlSessionFactory;

public class StudentService {
	private static final Logger logger = Logger.getLogger(StudentService.class);

	private static final StudentService instance = new StudentService();

	private StudentService() {
	}

	public static StudentService getInstance() {
		return instance;
	}
	
	public Student findStudentById(int studId){
		logger.debug("findStudentById()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(studId);
		}finally{
			sqlSession.close();
		}
	}
	
	public int insertStudentAutoIncrement(Student student){
		logger.debug("insertStudent()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int result = studentMapper.insertStudentAutoIncrement(student);
			sqlSession.commit();
			return result;
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally{
			sqlSession.close();
		}
	}
	
	public int updateStudent(Student student){
		logger.debug("updateStudent()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int result = studentMapper.updateStudent(student);
			sqlSession.commit();
			return result;
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally{
			sqlSession.close();
		}
	}
	
	public int deleteStudent(int id){
		logger.debug("deleteStudent()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int result = studentMapper.deleteStudent(id);
			sqlSession.commit();
			return result;
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Student> findAllStudents(){
		logger.debug("findAllStudents()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Student> findAllStudentForResultMap(){
		logger.debug("findAllStudentForResultMap()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudentForResultMap();
		}finally{
			sqlSession.close();
		}
	}
	
	public Student findStudentByIdFroResultMap(int studId){
		logger.debug("findStudentByIdFroResultMap()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentByIdFroResultMap(studId);
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Map<String, Object>> findAllStudentsForHashMap(){
		logger.debug("findAllStudentsForHashMap()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudentsForHashMap();
		}finally{
			sqlSession.close();
		}
	}
	
	public Map<String, Object> findStudentByIdForHashMap(int studId){
		logger.debug("findStudentByIdForHashMap()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentByIdForHashMap(studId);
		}finally{
			sqlSession.close();
		}
	}
	
	public Student findStudentByIdForResultMapExtend(int studId){
		logger.debug("findStudentByIdForResultMapExtend()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try{
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		return studentMapper.findStudentByIdForResultMapExtend(studId);
		}finally{
			sqlSession.close();
		}
		
	}
	
	public Student selectStudentWithAdderssResultOneToOne(int studId){
		logger.debug("studentWithAdderssResultOneToOne()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try{
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		return studentMapper.selectStudentWithAdderssResultOneToOne(studId);
		}finally{
			sqlSession.close();
		}
	}
	
	public Student findStudentWithAddressOneToOneNested(int studId){
		logger.debug("studentWithAddressOneToOneNested()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try{
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		return studentMapper.findStudentWithAddressOneToOneNested(studId);
		}finally{
			sqlSession.close();
		}
	}

}
