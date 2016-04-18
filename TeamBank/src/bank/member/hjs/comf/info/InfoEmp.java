package bank.member.hjs.comf.info;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.comp.DInputDBtnP;
import BankPanel.comp.TablePanel;
import BankPanel.jdbc.ConnectionFactory;
import bank.dto.Employee;
import bank.main.MainFrame;
import bank.main.MainPanel;
import bank.member.hjs.dao.BankDao;
import bank.member.hjs.service.InfoService;

public class InfoEmp extends DInputDBtnP implements FocusListener {
	TablePanel info = new TablePanel();

	public InfoEmp(TablePanel info) {
		this.info = info;
		getPanelEditable().getTfValue().addFocusListener(this);
	}

	public void clear() {
		getPanelEditable().setTfValue("");
		getPanelNonEditable().setTfValue("");
		getBtnAction().setEnabled(false);
		info.getTable().setVisible(false);
	}

	@Override
	protected void btnOkactionPerformed(ActionEvent e) {
		try {
			isCheck();
			Connection con = ConnectionFactory.getConnection();
			Employee dto = BankDao.getInstace().
					selectCode(con, getPanelEditable().getTfValue().getText().trim());

			String name = dto.getEmpName();
			String auth = dto.getEmpAuth();

			if (auth.equals("A") || auth.equals("C")) {
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

	private void isCheck() throws NullPointerException {
		if (getPanelEditable().getTfValue().getText().length() == 4) {

		} else if (getPanelEditable().getTfValue().getText().length() == 0) {
			throw new NullPointerException("코드를 입력하세요!!");
		} else {
			throw new NullPointerException("잘못된 코드입니다.");
		}

	}

	@Override
	protected void btnActionactionPerformed(ActionEvent e) {
		info.refrashModel(InfoService.getInstace().getList());
		info.getTable().setVisible(true);
	}

	public void focusGained(FocusEvent e) {
		if (e.getSource() == getPanelEditable().getTfValue()) {
			thisPanelEditableTfValueFocusGained(e);
		}
	}

	public void focusLost(FocusEvent e) {
	}

	protected void thisPanelEditableTfValueFocusGained(FocusEvent e) {
		clear();
	}
}
