package bank.member.ljh.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.dto.BankBook;
import bank.dto.Client;
import bank.dto.Employee;
import bank.member.ljh.dao.PayAndDrawDao;


public class PayAndDrawSelectService {
	private static final PayAndDrawSelectService instance = new PayAndDrawSelectService();

	public static PayAndDrawSelectService getInstance() {
		return instance;
	}

	public PayAndDrawSelectService() {
	}
	
	public Employee SelectEmployee(String emp){
		Connection con = null;
		Employee result = null;
		try {
			con = ConnectionFactory.getConnection();			
			result = PayAndDrawDao.getIntance().selectEmployeeByEmpCode(con, emp);
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "검색 실패.");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(con);
		}
		return result;
	}
	
	public Client SelectClient(String clt) throws SQLException{
		Connection con = null;
		Client result = null;
		try {
			con = ConnectionFactory.getConnection();			
			result = PayAndDrawDao.getIntance().selectCltNameByAccountNum(con, clt);
			
				
		}finally{
			JdbcUtil.close(con);
		}
		return result;
	}
	
	
	public BankBook SelectBalance(String bb) throws SQLException{
		Connection con = null;
		BankBook result = null;
		try {
			con = ConnectionFactory.getConnection();			
			result = PayAndDrawDao.getIntance().selectBalanceByAccountNum(con, bb);
			
				
		}finally{
			JdbcUtil.close(con);
		}
		return result;
	}
	
}
