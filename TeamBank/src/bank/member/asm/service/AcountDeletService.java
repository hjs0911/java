package bank.member.asm.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.dto.BankBook;
import bank.member.asm.dao.BankDao;


public class AcountDeletService {
	private static final AcountDeletService instance = new AcountDeletService();

	public static AcountDeletService getInstance() {
		return instance;
	}

	public void  AcountDelet(BankBook com) throws SQLException {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			BankDao dao = BankDao.getinstance();
			int result = dao.AcountDelteByItem(con, com);
			
			  
			if (result > 0)
				JOptionPane.showMessageDialog(null, "삭제 되었습니다");
		} finally {
			JdbcUtil.close(con);
		}

	}

}
