package bank.member.yjy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.swing.table.DefaultTableModel;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.data.TableUtil;
import bank.member.yjy.dao.BankDao;

public class ActionService {
	private static final ActionService instance = new ActionService();	

	public static ActionService getInstance() {
		return instance;
	}

	private ActionService() {}

	public DefaultTableModel getRowData(boolean t,String accountnumber) {
		DefaultTableModel model = null;
		String[][] datas = null;
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			if (t) {
				datas = BankDao.getInstance().selectClientByAll(con);
				model = new DefaultTableModel(datas, TableUtil.CLTNAMES);
			} else {
				
				datas = BankDao.getInstance().selectTrnHistoryByAll(con, accountnumber);
				DecimalFormat df=new DecimalFormat("#,###");
				
				int i=0;
				for(String[] s:datas){
					datas[i][1]=df.format((Integer.parseInt(s[1])));
					datas[i][2]=df.format((Integer.parseInt(s[2])));
					datas[i][3]=df.format((Integer.parseInt(s[3])));
					i++;
				}
				model = new DefaultTableModel(datas, TableUtil.BANKBOOKTRNNAMES);				
			}
		} catch (SQLException e) {
		} finally {
			JdbcUtil.close(con);
		}
		
		return model;
	}
	
	

}
