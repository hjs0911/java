package bank.member.asm.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.dto.Employee;
import bank.member.asm.dao.BankDao;

public class EmpDeletService {
 private static EmpDeletService instance = new  EmpDeletService();
	
	public static EmpDeletService getInstance() {
		return instance;
	}

  public EmpDeletService(){}

public void EmpDelet(Employee comp) throws SQLException {
     Connection con = null;
     try {
		con = ConnectionFactory.getConnection();
		 BankDao dao= BankDao.getinstance();
		 int result = dao.EmployeeDelte(con, comp);
			if (result > 0)
				JOptionPane.showMessageDialog(null, "삭제 되었습니다");
     } catch (Exception e) {
    	 JOptionPane.showMessageDialog(null, "직원이존재하지 않습니다", "오류 메시지", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			JdbcUtil.close(con);
		}

	}
  
 

}
