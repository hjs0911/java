package bank.member.yjy.comf;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BankPanel.comp.DInputDBtnP;
import BankPanel.comp.TablePanel;
import bank.data.TableUtil;

public class SevenMain extends JPanel {
	
	private DInputDBtnP pEmp1;
	protected TablePanel pt;
	

	public SevenMain() {
		setLayout(new BorderLayout());
		
		pEmp1 = new DBtnEmp(this);
		add(pEmp1,BorderLayout.NORTH);
		
		pEmp1.getPanelEditable().setLblTitle("사원코드");
		pEmp1.getPanelNonEditable().setLblTitle("사원명");		
		
		pt = new TablePanel();
		add(pt, BorderLayout.CENTER);
		pt.refrashModel(TableUtil.startModel(TableUtil.CLTNAMES));
		pt.tableCellRender(SwingConstants.CENTER, 0,1,2,3);
		
	}

}
