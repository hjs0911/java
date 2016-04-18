package bank.member.ljh.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.dto.Client;
import bank.member.ljh.dao.ClientDao;

public class ClientSearchService {
	private static final ClientSearchService instance = new ClientSearchService();

	public static ClientSearchService getInstance() {
		return instance;
	}

	public ClientSearchService() {
	}
	
	public Client SearchClient(String clt){
		Connection con = null;
		Client result = null;
		try {
			con = ConnectionFactory.getConnection();			
			result = ClientDao.getIntance().selectClientByCltCode(con, clt);
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "검색 실패.");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(con);
		}
		return result;
	}
}
