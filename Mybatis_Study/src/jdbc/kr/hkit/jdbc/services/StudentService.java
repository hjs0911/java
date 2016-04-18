package kr.hkit.jdbc.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import kr.hkit.dto.Student;
import kr.hkit.jdbc.util.ConnectionFactory;
import kr.hkit.util.JdbcUtil;

public class StudentService {
	private static final StudentService intance = new StudentService();

	public static StudentService getIntance() {
		return intance;
	}

	private StudentService() {}
	
	public Student findStudentById(int studentId){
		Student student = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		con = ConnectionFactory.getInstance();
		String sql = "select * from student where stud_id = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, studentId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				student = getStudent(rs);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		return student;
	}

	private Student getStudent(ResultSet rs) throws SQLException {
		Student student = new Student();
		student.setStudId(rs.getInt("stud_id"));
		student.setName(rs.getString("name"));
		student.setEmail(rs.getString("email"));
		student.setDob(rs.getDate("dob"));
		return student;
	}
	
	public int createStudent(Student student){
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		con = ConnectionFactory.getInstance();
		String sql = "insert into student values(?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getStudId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getEmail());
			pstmt.setTimestamp(4, new Timestamp(student.getDob().getTime()));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("중복 학생 존재!!!");
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		return result;
		
	}
}
