package kr.hkit.mybatis_dev.services;

import kr.hkit.mybatis_dev.dto.Tutor;
import kr.hkit.mybatis_dev.mappers.TutorMapper;
import kr.hkit.mybatis_dev.util.MybatisSqlSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class TutorService {
	private static final Logger logger = Logger.getLogger(TutorService.class);
	
	private static final TutorService instance = new TutorService();

	public static TutorService getInstance() {
		return instance;
	}

	private TutorService() {
	}
	
	public Tutor findTutorById(int tutorId){
		logger.debug("findTutorById(");
		SqlSession sqlSession = MybatisSqlSessionFactory.openSession();
		
		try{
			TutorMapper tutorMapper = sqlSession.getMapper(TutorMapper.class);
			return tutorMapper.findTutorById(tutorId);
		}finally{
			sqlSession.close();
		}
	}
	
}
