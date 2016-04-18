package kr.hkit.mybatis.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.w3c.dom.ranges.RangeException;

import kr.hkit.dto.Student;
import kr.hkit.mybatis.mappers.StudentMapper;
import kr.hkit.mybatis.util.MybatisSqlSessionFactory;

public class StudentService {
	private static final StudentService instance = new StudentService();

	public static StudentService getInstance() {
		return instance;
	}

	private StudentService() {}
	
	private static final Logger logger = Logger.getLogger(StudentService.class);
	
	public Student findStudentById(int studId){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try{
			String sql = "kr.hkit.mybatis.mappers.StudentMapper.findStudentById";
			return sqlSession.selectOne(sql, studId);
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Student> findAllStudents(){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try{
			String sql = "kr.hkit.mybatis.mappers.StudentMapper.findAllStudents";
			return sqlSession.selectList(sql);
		}finally{
			sqlSession.close();
		}
	}
	
	public int insertStudent(Student student){
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try{
			String sql = "kr.hkit.mybatis.mappers.StudentMapper.insertStudent";
			int result =  sqlSession.insert(sql, student);
			if(result > 0){
				sqlSession.commit();
			}
			return result;
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Student> findAllStudentForInterface(){
		logger.debug("findAllStudentForInterface()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudentForInterface();
		}finally{
			sqlSession.close();
		}
		
	}
	
	public Student findStudentByIdForInterface(int studId){
		logger.debug("findStudentByIdForInterface()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentByIdForInterface(studId);
		}finally{
			sqlSession.close();
		}
	}
	
	public int createStudentForInterface(Student student){
		logger.debug("insertStudent()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int result = studentMapper.createStudentForInterface(student);
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
	
	public List<Student> findAllStudentInterfaceForMixing(){
		logger.debug("findAllStudentsForInterface()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudentsForMixing();
		}finally{
			sqlSession.close();
		}
		
	}
	
	public Student findStudentByIdInterfaceForMixing(int studId){
		logger.debug("findStudentByIdForInterface()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentByIdForMixing(studId);
		}finally{
			sqlSession.close();
		}
	}
	
	public int createStudentInterfaceForMixing(Student student){
		logger.debug("insertStudent()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int result = studentMapper.insertStudentForMixing(student);
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
}
