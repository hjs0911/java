package bank.member.hjs.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.member.hjs.dao.BankDao;

public class InterService {
	private static final InterService instace = new InterService();
	public static final String[] INTER_NAME = {"계좌번호", "이자율", "고객코드", "등급", "현재잔액", "수정잔액"};

	public static InterService getInstace() {
		return instace;
	}

	public InterService() {	}
	
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
			datas = BankDao.getInstace().selectList(con, "v_inter", INTER_NAME.length);
			model = new DefaultTableModel(datas, INTER_NAME);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(con);
		}
		return model;
		
	}
}
