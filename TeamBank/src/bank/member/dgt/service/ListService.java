package bank.member.dgt.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.data.TableUtil;
import bank.member.dgt.dao.BankBookDao;


public class ListService {
	private static final ListService instance = new ListService();
	public static ListService getInstance() {
		return instance;
	}
	
	

	public DefaultTableModel getRowDate() {
		DefaultTableModel model = null;
		String[][] datas = null;
		Connection con = null;

		try {
			con = ConnectionFactory.getConnection();
			datas = BankBookDao.getInstance().selectClientBookByAll(con);
			model = new DefaultTableModel(datas, TableUtil.BANKBOOKTABLENAMES);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con);
		}
		return model;
	}

	public DefaultTableModel getTrnNames(String StartDay, String EndDay) {
		DefaultTableModel model = null;
		String[][] datas = null;
		Connection con = null;

		try {
			con = ConnectionFactory.getConnection();
			datas = BankBookDao.getInstance().selectTrnList(con, StartDay, EndDay);
			model = new DefaultTableModel(datas, TableUtil.TRNNAMES);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con);
		}
		return model;
	}

	public String[] AllSum(String StartDay, String EndDay) {
		String[] date = null;
		Connection con = null;
		
		try{	
		con = ConnectionFactory.getConnection();
		date = BankBookDao.getInstance().getAllSum(con,StartDay, EndDay);
		}finally{
			JdbcUtil.close(con);
		}
		return date;
	}
}
