package bank.member.yjy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import BankPanel.jdbc.JdbcUtil;
import bank.dto.Client;
import bank.dto.Employee;

public class BankDao {
	private static final BankDao instance = new BankDao();

	public static BankDao getInstance() {
		return instance;
	}

	private BankDao() {
	}

	public int selectCCnt(Connection con) throws SQLException {
		String sql = "select count(*) from Client";
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

	public int selectTCnt(Connection con, String accountnumber) throws SQLException {
		String sql = "select count(*) from TrnHistory where accountnumber=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountnumber);
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

	public String[][] selectClientByAll(Connection con) throws SQLException {
		String sql = "select cltcode, cltpass, cltname, cltgrade from Client";
		int rowCnt = selectCCnt(con);
		String[][] datas = new String[rowCnt][4];
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 0;
			while (rs.next()) {
				for (int j = 0; j < 4; j++) {
					datas[i][j] = rs.getString(j + 1);
					
				}i++;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return datas;
	}

	public String[][] selectTrnHistoryByAll(Connection con, String accountnumber) throws SQLException {
		String sql = "select trndate, case when trntype='I' then trnmoney else '0' end as '입금',"
				+ "case when trntype='D' then trnmoney else '0' end as '출금',balance "
				+ "from trnhistory where accountnumber=? order by trndate desc";
		int rowCnt = selectTCnt(con, accountnumber);
		String[][] datas = new String[rowCnt][4];
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountnumber);
			rs = pstmt.executeQuery();
			
			int i = 0;
			
			while (rs.next()) {
				
				for (int j = 0; j < 4; j++) {
					datas[i][j] = rs.getString(j + 1);
					
				}
				i++;
				
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return datas;
	}

	public Employee selectEmpNameByEmpCode(Connection con, String empcode) throws SQLException {
		String sql = "select empname, empauth from Employee where empcode=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee emp = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empcode);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				emp = new Employee();
				emp.setEmpName(rs.getString(1));
				emp.setEmpAuth(rs.getString(2));
			} else {
				throw new SQLException("존재하지 않습니다.");
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return emp;
	}

	public Client selectCltNameByAccountnumber(Connection con, String accountnumber) throws SQLException {
		String sql = "select cltname " + "from bankbook b, client c " + "where b.cltcode=c.cltcode and accountnumber=?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Client clt = null;
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, accountnumber);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				clt = new Client();
				clt.setCltName(rs.getString(1));
			} else {
				throw new SQLException("존재하지 않습니다.");
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return clt;
	}
}
