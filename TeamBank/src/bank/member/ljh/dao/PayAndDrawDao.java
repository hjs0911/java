package bank.member.ljh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.JdbcUtil;
import bank.dto.BankBook;
import bank.dto.Client;
import bank.dto.Employee;
import bank.dto.TrnHistory;

public class PayAndDrawDao {
	private static final PayAndDrawDao intance = new PayAndDrawDao();

	public static PayAndDrawDao getIntance() {
		return intance;
	}

	private PayAndDrawDao() {
	}

	public Employee selectEmployeeByEmpCode(Connection con, String empcode) throws SQLException {
		String sql = "select empname, empauth from employee where empcode=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employee emp = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, empcode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				emp = new Employee();

				emp.setEmpAuth(rs.getString(2));
				if (emp.getEmpAuth().equals("A") || emp.getEmpAuth().equals("B")) {
					emp.setEmpName(rs.getString("empname"));
				} else {

					JOptionPane.showMessageDialog(null, "권한이 없습니다.");
				}
			} else {

				JOptionPane.showMessageDialog(null, "존재하지 않습니다..");
			}
		} catch (Exception e) {

		} finally {

			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return emp;

	}

	public Client selectCltNameByAccountNum(Connection con, String accountnumber) {
		String sql = "select b.accountnumber, b.cltcode, c.cltname, c.cltpass from bankbook b, client c where c.cltcode=b.cltcode and accountnumber=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Client clt = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountnumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				clt = new Client();
				clt.setCltName(rs.getString("cltname"));
				clt.setCltPass(rs.getString(4));

			} else {

				JOptionPane.showMessageDialog(null, "존재하지 않습니다..");
			}
		} catch (Exception e) {

		} finally {

			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return clt;
	}

	public Client PassByCltpass(Connection con, String cltpass) {
		String sql = "select cltname, cltpass from client where cltpass=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		Client clt = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cltpass);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				clt = new Client();

				if (clt.getCltPass().equals(rs.getString(2))) {
					JOptionPane.showMessageDialog(null, "인증성공");
				} else {

					JOptionPane.showMessageDialog(null, "인증실패");
				}
			} else {

				JOptionPane.showMessageDialog(null, "존재하지 않습니다..");
			}
		} catch (Exception e) {

		} finally {

			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return clt;
	}

	public BankBook selectBalanceByAccountNum(Connection con, String accountnumber) {
		String sql = "select balance from bankbook where accountnumber=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BankBook bb = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, accountnumber);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				bb = new BankBook();

				bb.setBalance(rs.getString(1));
			} else {

				
			}
		} catch (Exception e) {

		} finally {

			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return bb;
	}

	public int inputBalanceByAccountNum(Connection con, String accountnumber, int plusBalance) throws SQLException {
		String sql = "update bankbook set balance = ? where accountnumber=?";
		PreparedStatement pstmt = null;
		
		try{
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, plusBalance);
		pstmt.setString(2, accountnumber);
		return pstmt.executeUpdate();
		}finally {
			JdbcUtil.close(pstmt);
		}

}

	public int insertData(Connection con,TrnHistory th, int pbalance ) throws SQLException {
		String sql = "insert into trnhistory values(?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try{
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, th.getEmpCode());
		pstmt.setString(2, th.getAccountnumber());
		pstmt.setString(3, th.getTrntype());
		pstmt.setString(4, th.getTrndate());
		pstmt.setString(5, th.getTrnmoney());
		pstmt.setInt(6, pbalance);
		
		return pstmt.executeUpdate();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
	}
}
