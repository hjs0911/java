package bank.member.yjy.comf;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import BankPanel.comp.DInputBtnP;
import BankPanel.comp.DInputDBtnP;
import bank.member.yjy.service.OKService;

public class BtnEmp extends DInputBtnP {	
	protected DInputDBtnP pAccount;
	public BtnEmp(DInputDBtnP pAccount) {
		this.pAccount = pAccount;
	}
	@Override
	protected void btnOkactionPerformed(ActionEvent e) {
		if (getPanelEditable().getTfValue().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		} else {
			String str = OKService.getInstance().check(getPanelEditable().getTfValue().getText());
			if (str == null) { // 코드가 존재하지 않을때
				getPanelEditable().setTfValue("");
			} else {
				getPanelNonEditable().setTfValue(str);
				pAccount.getPanelEditable().getTfValue().setEnabled(true);
				}
		}
		pAccount.getBtnOk().setEnabled(true);
		pAccount.getBtnAction().setEnabled(false);
	}
};

