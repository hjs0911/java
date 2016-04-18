package bank.member.hjs.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.member.hjs.dao.BankDao;

public class InfoService {
	private static final InfoService instace = new InfoService();
	public static final String[] EMP_NAME = {"사원코드", "사원명", "직급", "권한"};
	public static InfoService getInstace() {
		return instace;
	}

	private InfoService() {	}
	
	/*public void selectService(BankDto bkd){
		Connection con = ConnectionFactory.getConnection();
		BankDao dao = BankDao.getInstace();
		int result = dao.selectCode(con, bkd);
	}*/
	
	public DefaultTableModel getList(){
		DefaultTableModel model = null;
		String[][] datas = null;
		Connection con = null;
		
		try {
			con = ConnectionFactory.getConnection();
			datas = BankDao.getInstace().selectList(con, "employee", EMP_NAME.length);
			model = new DefaultTableModel(datas, EMP_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(con);
		}
		return model;
		
	}
}
