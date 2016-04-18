package bank.member.hjs.comf.info;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import BankPanel.comp.TablePanel;
import bank.member.hjs.service.InfoService;

public class Info extends JPanel {
	private TablePanel pIfList;

	/**
	 * Create the panel.
	 */
	public Info() {
		setLayout(new BorderLayout(0, 0));
		pIfList = new TablePanel();
		InfoEmp pIfEmpCode = new InfoEmp(pIfList);
		pIfEmpCode.getBtnAction().setEnabled(false);
		pIfEmpCode.getPanelNonEditable().setLblTitle("사원명");
		pIfEmpCode.getPanelEditable().setLblTitle("사원코드");
		add(pIfEmpCode, BorderLayout.NORTH);

		pIfList.getTable().setModel(new DefaultTableModel(new Object[][] {}, InfoService.EMP_NAME));
		add(pIfList, BorderLayout.CENTER);

		/*
		 * DefaultTableModel model = InfoService.getInstace().getList();
		 * pIfList.getTable().setVisible(true); pIfList.refrashModel(model);
		 */

	}

}
