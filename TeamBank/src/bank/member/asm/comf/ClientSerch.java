package bank.member.asm.comf;

import java.awt.event.ActionEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.comp.DInputBtnP;
import BankPanel.jdbc.ConnectionFactory;
import bank.dto.Client;
import bank.member.asm.dao.BankDao;

public class ClientSerch extends DInputBtnP {
	AcountControllerPanel ap;

	public ClientSerch(AcountControllerPanel ap) {
		super();
		this.ap = ap;
	}

	@Override
	protected void btnOkactionPerformed(ActionEvent e) {
		String result = JOptionPane.showInputDialog(null, "고객 코드를 입력하세요", "고객입력", JOptionPane.INFORMATION_MESSAGE).trim();
		BankDao dao = BankDao.getinstance();
		try {
			Client sub = dao.Serchclient(ConnectionFactory.getConnection(), result);
			ap.setclient(sub);
		} catch (SQLException e1) {

		}

	}

}
