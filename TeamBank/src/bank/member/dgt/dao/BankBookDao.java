package bank.member.dgt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BankPanel.jdbc.JdbcUtil;
import bank.dto.Employee;

public class BankBookDao {
	private static final BankBookDao instance = new BankBookDao();

	public static BankBookDao getInstance() {
		return instance;
	}

	private int selectCnt(Connection con) throws SQLException {
		String sql = "select count(*) from nowbankbook";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				throw new SQLException("존재하지 않습니다.");
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

	}

	public Employee selectEmpName(Connection con, String empcode) {
		String sql = "select empname,empauth from employee where empcode = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee dto = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empcode);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new Employee();
				dto.setEmpName(rs.getString(1));
				dto.setEmpAuth(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
		}
		return dto;
	}

	public String[][] selectClientBookByAll(Connection con) throws SQLException {
		String sql = "select * from nowbankbook";
		int rowCnt = selectCnt(con);
		String[][] datas = new String[rowCnt][6];
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				datas[i][0] = rs.getString(1);
				datas[i][1] = rs.getString(2);
				datas[i][2] = rs.getString(3);
				datas[i][3] = rs.getString(4);
				datas[i][4] = rs.getString(5);
				datas[i][5] = rs.getString(6);
				i++;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return datas;
	}

	public int selectTrnCnt(Connection con, String startDay, String endDay) throws SQLException {
		String sql = "select count(*) from DaysTrnHistorys where trndate between ? and ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startDay);
			pstmt.setString(2, endDay);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				throw new SQLException("존재하지 않습니다.");
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}

	}

	public String[][] selectTrnList(Connection con, String startDay, String endDay) throws SQLException {
		String sql = "select * from DaysTrnHistorys where trndate between ? and ?";
		int rowCnt = selectTrnCnt(con, startDay, endDay);
		String[][] datas;
		if(rowCnt==0){
			datas = new String[rowCnt][4];
		}else{
			datas = new String[rowCnt + 1][4];
		}
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startDay);
			pstmt.setString(2, endDay);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				datas[i][0] = rs.getString(1);
				datas[i][1] = rs.getString(2);
				datas[i][2] = rs.getString(3);
				datas[i][3] = rs.getString(4);
				i++;
			}
			if (!(i == 0)) {
				datas[i][0] = "합계";
				String[] st = getAllSum(con, startDay, endDay);
				datas[i][2] = st[0];
				datas[i][3] = st[1];
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return datas;
	}

	public String[] getAllSum(Connection con, String startDay, String endDay) {
		String sql = "select sum(Inputs) as '입금',sum(OUTPUTs) as '출금' from DaysTrnHistorys where trndate between ? and ?";
		String[] date = new String[2];
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, startDay);
			pstmt.setString(2, endDay);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				date[0] = rs.getString(1);
				date[1] = rs.getString(2);
			}
			if (date[0] == null) {
				date[0] = "0";
				date[1] = "0";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return date;
	}
}
