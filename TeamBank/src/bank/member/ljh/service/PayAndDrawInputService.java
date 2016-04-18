package bank.member.ljh.service;

import java.sql.Connection;
import java.sql.SQLException;

import BankPanel.jdbc.ConnectionFactory;
import BankPanel.jdbc.JdbcUtil;
import bank.dto.TrnHistory;
import bank.member.ljh.dao.PayAndDrawDao;

public class PayAndDrawInputService {
	private static final PayAndDrawInputService instance = new PayAndDrawInputService();

	public static PayAndDrawInputService getInstance() {
		return instance;
	}

	public PayAndDrawInputService() {
	}

	public int inputBalance(String accountnumber, int plusBalance) throws SQLException {
		Connection con = null;
		int result;
		try {
			con = ConnectionFactory.getConnection();
			result = PayAndDrawDao.getIntance().inputBalanceByAccountNum(con, accountnumber, plusBalance);

		} finally {
			JdbcUtil.close(con);
		}
		return result;
	}

	public int inputData(TrnHistory th, int pbalance) throws SQLException {
		Connection con = null;
		int result;
		try {
			con = ConnectionFactory.getConnection();
			result = PayAndDrawDao.getIntance().insertData(con, th, pbalance);

		} finally {
			JdbcUtil.close(con);
		}
		return result;
	}
}
