package bank.member.hjs.comf.inter;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import BankPanel.comp.DInputDBtnP;
import BankPanel.comp.TablePanel;
import BankPanel.jdbc.ConnectionFactory;
import bank.dto.Employee;
import bank.dto.TrnHistory;
import bank.main.MainFrame;
import bank.main.MainPanel;
import bank.member.hjs.dao.BankDao;
import bank.member.hjs.service.InterService;
import bank.member.ljh.dao.PayAndDrawDao;

public class InterEmp extends DInputDBtnP implements FocusListener {
	TablePanel inter;

	public InterEmp(TablePanel inter) {
		this.inter = inter;
		getPanelEditable().getTfValue().addFocusListener(this);
	}

	@Override
	protected void btnOkactionPerformed(ActionEvent e) {
		try {
			isCheck();
			Connection con = ConnectionFactory.getConnection();
			Employee dto = BankDao.getInstace().selectCode(con, getPanelEditable().getTfValue().getText().trim());

			String name = dto.getEmpName();
			String auth = dto.getEmpAuth();

			if (auth.equals("A") || auth.equals("B")) {
				getPanelNonEditable().setTfValue(name);
				getBtnAction().setEnabled(true);
			} else {
				JOptionPane.showMessageDialog(null, name + "님은 권한이 없습니다.");
				clear();
				MainFrame.getInstance().repaintPane(new MainPanel());
			}
		} catch (NullPointerException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}

	}

	@Override
	protected void btnActionactionPerformed(ActionEvent e) {
		inter.refrashModel(InterService.getInstace().getList());
		inter.getTable().setVisible(true);

		try {

			ArrayList<String> arAccountNumber = BankDao.getInstace()
					.getAccountNumber(ConnectionFactory.getConnection());
			for (String s : arAccountNumber) {
				TrnHistory th = getTrnHistory(s);
				PayAndDrawDao.getIntance()
				.insertData(ConnectionFactory.getConnection(), 
						th,	Integer.parseInt(th.getBalance()));
			}
			BankDao.getInstace().editInter(ConnectionFactory.getConnection());
		} catch (SQLException e1) {
		}

	}

	private TrnHistory getTrnHistory(String accountnumber) {
		TrnHistory th = new TrnHistory();
		String[] data = BankDao.getInstace()
				.interMoney(ConnectionFactory.getConnection(), accountnumber);
		th.setAccountnumber(accountnumber);
		th.setEmpCode(getPanelEditable().getTfValue().getText());
		th.setTrntype("I");
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		th.setTrndate(sdf.format(now));

		String[] kk = calBalance(data);
		th.setTrnmoney(kk[0]);
		th.setBalance(kk[1]);

		return th;
	}

	private String[] calBalance(String[] accountnumber){
		String[] data = new String[2];
		
		double balance = Double.parseDouble(accountnumber[0]);
		double interestrate = Double.parseDouble(accountnumber[2]);
		double editBalance = 0;
		double nowBalance = balance;
		data[0] = String.valueOf(balance);
		switch (accountnumber[1]) {
		case "L":
			editBalance = balance + (balance * (0.01 * interestrate));
			break;
		case "M":
			editBalance = balance + (balance * (0.01 * interestrate+0.005));
			break;
		case "H":
			editBalance = balance + (balance * (0.01 *interestrate+0.01));
			break;
		}
		
		data[0] = String.valueOf(Math.round(editBalance-nowBalance));
		data[1] = String.valueOf(Math.round(editBalance));
		
		return data;
	}

	private void isCheck() throws NullPointerException {
		if (getPanelEditable().getTfValue().getText().length() == 4) {

		} else if (getPanelEditable().getTfValue().getText().length() == 0) {
			throw new NullPointerException("코드를 입력하세요!!");
		} else {
			throw new NullPointerException("잘못된 코드입니다.");
		}

	}

	public void clear() {
		getPanelEditable().setTfValue("");
		getPanelNonEditable().setTfValue("");
		getBtnAction().setEnabled(false);
		inter.getTable().setVisible(false);
	}

	public void focusGained(FocusEvent e) {
		if (e.getSource() == getPanelEditable().getTfValue()) {
			try {
				thisPanelEditableTfValueFocusGained(e);
			} catch (NullPointerException e1) {
			}
		}
	}

	public void focusLost(FocusEvent e) {
	}

	protected void thisPanelEditableTfValueFocusGained(FocusEvent e) {
		clear();
	}

}
