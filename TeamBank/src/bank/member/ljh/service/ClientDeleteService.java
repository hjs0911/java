package bank.member.ljh.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.member.ljh.dao.ClientDao;



public class ClientDeleteService {
	private static final ClientDeleteService instance = new ClientDeleteService();

	public static ClientDeleteService getInstance() {
		return instance;
	}

	public ClientDeleteService() {
	}
	
	public void deleteClient(String clt){
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();			
			int result = ClientDao.getIntance().deleteByItem(con, clt);
			if(result>0)
				JOptionPane.showMessageDialog(null, "삭제 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "삭제 실패.");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(con);
		}
		
	}
}
