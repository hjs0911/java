package bank.member.asm.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.dto.Employee;
import bank.member.asm.dao.BankDao;

public class EmpInputService {
	private final static EmpInputService instance= new EmpInputService(); 

	public static EmpInputService getinstance() {
		// TODO Auto-generated method stub
		return instance;
	}
	private EmpInputService(){}

	public void insertcomplet(Employee ccd) {
		Connection con = null;
		
		try {
			con= ConnectionFactory.getConnection();
			 BankDao  dao = BankDao.getinstance();
	         int result = dao.EmpInser(con, ccd);
	         if (result > 0)
					JOptionPane.showMessageDialog(null, "직원이 입력 되었습니다");
			} catch (SQLException e) {
				if (e.getErrorCode() == 1062)
					JOptionPane.showMessageDialog(null, " 직원 중복 ");
				else
					e.printStackTrace();
			} finally {
				JdbcUtil.close(con);
			}

		}


	}
