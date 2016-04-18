package bank.member.yjy.comf;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BankPanel.comp.DInputDBtnP;
import bank.member.yjy.service.ActionService;
import bank.member.yjy.service.OKService;

public class DBtnAccount extends DInputDBtnP {
	private NineMain main;

	public DBtnAccount(NineMain main) {
		this.main = main;
		getBtnAction().setEnabled(false);
	}
	@Override
	protected void btnOkactionPerformed(ActionEvent e) {
		if (getPanelEditable().getTfValue().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		} else {
			String str = OKService.getInstance().check2(getPanelEditable().getTfValue().getText());
			if (str == null) {
				getPanelEditable().setTfValue("");
			} else {
				getPanelNonEditable().setTfValue(str);
				getPanelEditable().getTfValue().setEnabled(true);
				getBtnAction().setEnabled(true);
			}
		}
	}

	@Override
	protected void btnActionactionPerformed(ActionEvent e) {
		DefaultTableModel model = ActionService.getInstance().getRowData(false, getPanelEditable().getTfValue().getText().trim());
		
		main.pt.refrashModel(model);
		main.pt.tableCellRender(SwingConstants.CENTER, 0,1,2,3);
	}
};


