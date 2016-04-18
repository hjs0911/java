package bank.member.yjy.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.dto.Client;
import bank.dto.Employee;
import bank.main.MainFrame;
import bank.main.MainPanel;
import bank.member.yjy.dao.BankDao;

public class OKService {
	private static final OKService instance = new OKService();

	public static OKService getInstance() {
		return instance;
	}

	private OKService() {
	}

	public String check(String empcode) {
		Connection con = null;
		String str = null;
		try {
			con = ConnectionFactory.getConnection();
			Employee emp = BankDao.getInstance().selectEmpNameByEmpCode(con, empcode);
			if (emp.getEmpAuth().equals("A") || emp.getEmpAuth().equals("C")) {
				str = emp.getEmpName();
			} else {
				JOptionPane.showMessageDialog(null, "사용권한이 없습니다.");
				MainFrame.getInstance().repaintPane(new MainPanel());;
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (Exception e) {

		} finally {
			JdbcUtil.close(con);
		}
		return str;
	}

	public String check2(String accountnumber) {
		Connection con = null;
		String str = null;
		try {
			con = ConnectionFactory.getConnection();
			Client clt = BankDao.getInstance().selectCltNameByAccountnumber(con, accountnumber);
			str = clt.getCltName();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (Exception e) {

		} finally {
			JdbcUtil.close(con);
		}
		return str;
	}
}
