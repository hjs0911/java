package kr.hkit.mybatis;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.hkit.mybatis.util.MybatisSqlSessionFactory;

public class MyBatisSqlSessionFactoryTest {
	private static SqlSession sqlSession;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sqlSession = MybatisSqlSessionFactory.openSession();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		sqlSession = null;
	}

	@Test
	public void testSqlSession() {
		Assert.assertNotNull(sqlSession);
		System.out.println(sqlSession);
	}

}
