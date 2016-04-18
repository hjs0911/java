package kr.hkit.jdbc;

import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.hkit.jdbc.util.ConnectionFactory;

public class ConnectionFactoryTest {
	private static Connection con;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = ConnectionFactory.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con = null;
	}

	@Test
	public void testConnection() {
		Assert.assertNotNull(con);
		System.out.println(con);
	}

}
