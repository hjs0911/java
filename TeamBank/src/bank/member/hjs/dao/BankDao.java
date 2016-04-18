package bank.member.hjs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import BankPanel.jdbc.JdbcUtil;
import bank.dto.Employee;

public class BankDao {
	private static final BankDao instace = new BankDao();

	private BankDao() {}

	public static BankDao getInstace() {
		return instace;
	}
	
	public Employee selectCode(Connection con, String bkdCode) throws SQLException {
		String sql = "select empname, empauth "
				+ "from employee "
				+ "where empcode=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee bkDto = new Employee();
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bkdCode);
			rs=pstmt.executeQuery();
			if(rs.next()){				
				bkDto.setEmpName(rs.getString("empname"));
				bkDto.setEmpAuth(rs.getString("empauth"));
			}else{
				throw new SQLException("없는 사원 코드입니다.");
			}
		}finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return bkDto;		
	}
	
	public int selectCnt(Connection con, String tableName) throws SQLException{
		String sql = "select count(*) from " + tableName;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt(1);
			}else{
				throw new SQLException("존재하지 않음");
			}
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public String[][] selectList(Connection con, String tableName, int size)throws SQLException{
		String sql = "select * from "+ tableName;
		int aryLow = selectCnt(con, tableName); 
		
		String[][] datas = new String[aryLow][size];
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		int i = 0;
		while(rs.next()){
			for(int j=0; j<size; j++){
			datas[i][j] = rs.getString(j+1);
			}
			i++;
		}
		
		JdbcUtil.close(rs);
		JdbcUtil.close(pstmt);
		
		return datas;
	}
	
	public void editInter(Connection con){
		String sql = "update bankbook b, client c "
				+ "set balance=balance + (balance*(0.01*interestrate+"
				+"(case "
				+"when cltgrade = 'H' then 0.01 "
				+"when cltgrade = 'M' then 0.005 "
				+"else 0 "
				+"end)))"
				+"where b.cltcode = c.cltcode";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			int result = pstmt.executeUpdate();
			if(result>0){
				JOptionPane.showMessageDialog(null, "계산완료!!");
			}
		} catch (SQLException e) {
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
	}

	public String[] interMoney(Connection con, String accountnumber) {
		String sql = "select balance,cltgrade,interestrate "
				+ "from bankbook b, client c "
				+ "where accountnumber=? and b.cltcode = c.cltcode";
		
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String[] data=new String[3];
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountnumber);
			 rs = pstmt.executeQuery();
			if(rs.next()){
				data[0]=rs.getString(1);
				data[1]=rs.getString(2);
				data[2]=rs.getString(3);
			}
		} catch (SQLException e) {
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		return data;
		
	}

	public ArrayList<String> getAccountNumber(Connection con) {
		ArrayList<String> arAccountNumber=new ArrayList<>();
		String sql="select accountnumber from bankbook b, client c "
				+ "where b.cltcode = c.cltcode";
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			pstmt = con.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			while(rs.next()){
				arAccountNumber.add(rs.getString(1));				
			}
		} catch (SQLException e) {
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		return arAccountNumber;
	}
}
