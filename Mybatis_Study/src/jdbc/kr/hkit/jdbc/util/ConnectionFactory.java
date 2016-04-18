package kr.hkit.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final ConnectionFactory instance = new ConnectionFactory();

	public static Connection getInstance() {
		return instance.createConnection();
	}

	private ConnectionFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL Driver not Found!!!");
			System.exit(-1);
		}
	} //end of class
	
	private Connection createConnection(){
		Connection con = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/mybatis_study";
			String user = "mybatis_study";
			String password = "rootroot";
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.err.println("Error : Unable to Connection DataBase!!!");
		}
		return con;
	}

	
}
