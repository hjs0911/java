package bank.member.yjy.comf;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BankPanel.comp.DInputDBtnP;
import bank.member.yjy.service.ActionService;
import bank.member.yjy.service.OKService;

public class DBtnEmp extends DInputDBtnP {
	private SevenMain main;
	
	public DBtnEmp(SevenMain main) {
		this.main = main;
		getBtnAction().setEnabled(false);
	}

	@Override
	protected void btnOkactionPerformed(ActionEvent e) {
		if (getPanelEditable().getTfValue().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "빈칸이 있습니다.");
		} else {
			String str = OKService.getInstance().check(getPanelEditable().getTfValue().getText());
			if (str==null) {
				getPanelEditable().setTfValue("");
			} else {
				getPanelNonEditable().setTfValue(str);
				getBtnAction().setEnabled(true);
			}
		}
		
	}
	
	@Override
	protected void btnActionactionPerformed(ActionEvent e) {
		DefaultTableModel model=ActionService.getInstance().getRowData(true,"");
		main.pt.refrashModel(model);
		main.pt.tableCellRender(SwingConstants.CENTER, 0,1,2,3);
	}

}
