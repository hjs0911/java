package bank.member.ljh.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.dto.Client;
import bank.member.ljh.dao.ClientDao;




public class ClientSaveService {
	private final static ClientSaveService instance = new ClientSaveService();

	public static ClientSaveService getInstance() {
		return instance;
	}

	public ClientSaveService() {
	}

	public void insertClient(Client clt) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			ClientDao dao = ClientDao.getIntance();
			int result = dao.insertByItem(con, clt);
			if (result > 0)
				JOptionPane.showMessageDialog(null, "저장완료.");
		} catch (SQLException e) {
			if (e.getErrorCode() == 1062)

				JOptionPane.showMessageDialog(null, "고객코드가 중복.");
			else
				e.printStackTrace();

		} finally {
			JdbcUtil.close(con);
		}

	}
}
