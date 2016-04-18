package bank.member.ljh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.JdbcUtil;
import bank.dto.Client;

public class ClientDao {
	private static final ClientDao intance = new ClientDao();

	public static ClientDao getIntance() {
		return intance;
	}

	private ClientDao() {
	}

	// professor 테이블의 dml

	public int insertByItem(Connection con, Client clt) throws SQLException {
		String sql = "insert into client values(?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, clt.getCltCode());
			pstmt.setString(2, clt.getCltPass());
			pstmt.setString(3, clt.getCltName());
			pstmt.setString(4, clt.getCltGrade());

			return pstmt.executeUpdate();

		} finally {
			JdbcUtil.close(pstmt);
		}

	}

	public int deleteByItem(Connection con, String cltcode) throws SQLException {
		String sql = "delete from client where cltcode=?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cltcode);

			return pstmt.executeUpdate();

		} finally {
			JdbcUtil.close(pstmt);
		}

	}

	public Client selectClientByCltCode(Connection con, String cltcode) throws SQLException {
		String sql = "select cltcode, cltname, cltpass, cltgrade from client where cltcode=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Client clt = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cltcode);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				clt = new Client();
				clt.setCltCode(rs.getString("cltcode"));
				clt.setCltName(rs.getString("cltname"));
				clt.setCltPass(rs.getString("cltpass"));
				clt.setCltGrade(rs.getString("cltgrade"));
				JOptionPane.showMessageDialog(null, "검색 되었습니다.");
			} else {

				JOptionPane.showMessageDialog(null, "존재하지 않습니다..");
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return clt;

	}

}
