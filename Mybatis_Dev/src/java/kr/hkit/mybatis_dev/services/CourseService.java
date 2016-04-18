package kr.hkit.mybatis_dev.services;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import kr.hkit.mybatis_dev.dto.Course;
import kr.hkit.mybatis_dev.mappers.CourseMapper;
import kr.hkit.mybatis_dev.util.MybatisSqlSessionFactory;

public class CourseService {
	private static final Logger logger = Logger.getLogger(CourseService.class);
	private static final CourseService instance = new CourseService();

	public static CourseService getInstance() {
		return instance;
	}

	private CourseService() {}
	
	public List<Course> searchCourses(Map<String, Object> map){
		logger.debug("searchCourses()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try{
			CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
			return courseMapper.searchCourses(map);
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Course> searchCaseCourses(Map<String, Object> map){
		logger.debug("searchCaseCourses()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try{
			CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
			return courseMapper.searchCaseCourses(map);
		}finally{
			sqlSession.close();
		}
	}
	
	public List<Course> searchWhereCourses(Map<String, Object> map){
		logger.debug("searchWhereCourses()");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		try{
			CourseMapper courseMapper = sqlSession.getMapper(CourseMapper.class);
			return courseMapper.searchWhereCourses(map);
		}finally{
			sqlSession.close();
		}
	}

}
