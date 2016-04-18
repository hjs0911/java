package bank.member.asm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.JdbcUtil;
import bank.dto.BankBook;
import bank.dto.Client;
import bank.dto.Employee;


public class BankDao {
	private static final BankDao instance= new BankDao();
	  
	public static BankDao getinstance() {
		// TODO Auto-generated method stub
		return instance;
	}
	 String str;
	public int EmpInser(Connection con, Employee ccd) throws SQLException {
		String sql = "insert into employee values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ccd.getEmpCode());
			
			pstmt.setString(2, ccd.getEmpName());
			
			pstmt.setString(3, ccd.getEmpTitle());
			
			pstmt.setString(4, ccd.getEmpAuth());
			
			return pstmt.executeUpdate();
			
		} finally {

			JdbcUtil.close(pstmt);

		}



	}

	
	public Client Serchclient(Connection con, String cltcode) throws SQLException {
		String sql = "select cltcode, "

				+ "cltname "

				+ "from client where cltcode=?;";
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  Client com = null;
/*		  Client clinet = null;*/
		
		 try {
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, cltcode);
			   rs = pstmt.executeQuery();
			   if (rs.next()) {
				   com = new Client();
				   com.setCltCode(rs.getString("cltcode"));
			 
				   com.setCltName(rs.getString(2));
			 } else {
				 JOptionPane.showMessageDialog(null, "고객이 존재하지 않습니다", "오류 메시지", JOptionPane.ERROR_MESSAGE);
		
			 }
			  } finally {
			   JdbcUtil.close(rs);
			   JdbcUtil.close(pstmt);
			  }
			  return com;
			 }
	
	

	public int AcountInsert(Connection con, BankBook ccd) throws SQLException {
		String sql = "insert into bankbook values(?,?,?,?,?)";
		
		
		PreparedStatement pstmt = null;
		try{
		int count =0;
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, ccd.getAccountnumber());
		pstmt.setString(2, ccd.getCltcode());
		pstmt.setString(3, ccd.getOpeningdate());
		pstmt.setString(4, ccd.getInterestrate());
		pstmt.setString(5, Integer.toString(count));
		return pstmt.executeUpdate();
	}finally {
		JdbcUtil.close(pstmt);
	}
	}

	public BankBook Aserchclient(Connection con, String accountnumber) throws SQLException {
		String sql = "select b.accountnumber, "

				+ "b.cltcode, "+"c.cltname, " +"b.openingdate, "+"b.interestrate "

				+ "from bankbook b, client c "
				+ "where c.cltcode = b.cltcode and  b.accountnumber=?;";
	
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  BankBook com = null;
		  Client clinet = null;
		
		
		 try {
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, accountnumber);
			   rs = pstmt.executeQuery();
			   if (rs.next()) {
				   com = new BankBook();
				   clinet= new Client();
					
				   com.setAccountnumber(rs.getString("accountnumber"));
				   com.setCltcode(rs.getString(2));
				 
				   clinet.setCltName(rs.getString(3));
				   str=clinet.getCltName();
				   com.setOpeningdate(rs.getString(4));
				   com.setInterestrate(rs.getString(5));
				   
			
			 } else {
			    new Exception("고객님의 계좌가 존재하지 않아 삭제가 불가능 합니다");
			   }
			  } finally {
			   JdbcUtil.close(rs);
			   JdbcUtil.close(pstmt);
			  }
			  return com;
			 }
	  public String cltname(){
		 return str;
	  }
	

	public int AcountDelteByItem(Connection con, BankBook com) throws SQLException {
		String sql = "delete from bankbook where accountnumber=?";
		PreparedStatement pstmt = null;
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, com.getAccountnumber());
			return pstmt.executeUpdate();
		}finally {
			JdbcUtil.close(pstmt);
		}
	}

	public int EmployeeDelte(Connection con, Employee comp) throws SQLException {
		String sql = "DELETE FROM employee WHERE empcode=?";
		PreparedStatement pstmt = null;
		try {
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, comp.getEmpCode());
			return pstmt.executeUpdate();
			
		
		}finally {
			JdbcUtil.close(pstmt);
		}
		

	}

	public Employee EmpSerch(Connection con, String empcode) throws SQLException {
		String sql = "select empcode, "

				+ "empname, "+"emptitle, "+"empauth "

				+ "from employee "
				+ "where empcode=?;";
	
		  PreparedStatement pstmt = null;
		  ResultSet rs = null;
		  Employee com = null;
		
		
		 try {
			   pstmt = con.prepareStatement(sql);
			   pstmt.setString(1, empcode);
			   rs = pstmt.executeQuery();
			   if (rs.next()) {
				   com = new Employee();
					
					
				   com.setEmpCode(rs.getString("empcode"));
				   com.setEmpName(rs.getString(2));
				   com.setEmpTitle(rs.getString(3));
				   com.setEmpAuth(rs.getString(4));
				
			
			 } else {
			    new Exception("직원이존재하지 않습니다");
			   }
			  } finally {
			   JdbcUtil.close(rs);
			   JdbcUtil.close(pstmt);
			  }
			  return com;
			 }

}


