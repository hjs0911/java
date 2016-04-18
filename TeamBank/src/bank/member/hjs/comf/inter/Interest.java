package bank.member.hjs.comf.inter;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import BankPanel.comp.TablePanel;
import bank.member.hjs.service.InterService;

public class Interest extends JPanel{

	private TablePanel pIfList;


	/**
	 * Create the panel.
	 */
	public Interest() {
		setLayout(new BorderLayout(0, 0));
		pIfList = new TablePanel();
		InterEmp pIfEmpCode = new InterEmp(pIfList);
		pIfEmpCode.getBtnAction().setEnabled(false);
		pIfEmpCode.getPanelNonEditable().setLblTitle("사원명");
		pIfEmpCode.getPanelEditable().setLblTitle("사원코드");
		add(pIfEmpCode, BorderLayout.NORTH);
		
		pIfList.getTable().setModel(new DefaultTableModel(
			new Object[][] {
			},
			InterService.INTER_NAME
		));
		add(pIfList, BorderLayout.CENTER);

	}

}
