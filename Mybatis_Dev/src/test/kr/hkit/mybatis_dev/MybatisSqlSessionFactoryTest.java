package kr.hkit.mybatis_dev;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.hkit.mybatis_dev.util.MybatisSqlSessionFactory;

public class MybatisSqlSessionFactoryTest {
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
	public void test() {
		Assert.assertNotNull(sqlSession);
	}

}
