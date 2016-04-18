package bank.member.yjy.comf;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import BankPanel.comp.DInputBtnP;
import BankPanel.comp.DInputDBtnP;
import BankPanel.comp.TablePanel;
import bank.data.TableUtil;

public class NineMain extends JPanel {
	private JPanel pTrn;
	private DInputBtnP pEmp2;
	private DInputDBtnP pAccount;
	protected TablePanel pt;

	public NineMain() {
		setLayout(new BorderLayout(0, 0));

		pTrn = new JPanel();

		add(pTrn, BorderLayout.NORTH);
		pt = new TablePanel();
		pTrn.setLayout(new GridLayout(0, 1, 0, 0));
		pAccount = new DBtnAccount(this);
		
		pEmp2 = new BtnEmp(pAccount);
		pEmp2.getPanelEditable().setLblTitle("사원코드");
		pEmp2.getPanelNonEditable().setLblTitle("사원명");
		
		pTrn.add(pEmp2);
		pTrn.add(pAccount);
		
		pAccount.getPanelEditable().setLblTitle("계좌번호");
		pAccount.getPanelNonEditable().setLblTitle("고객명");
		pAccount.getPanelEditable().getTfValue().setEnabled(false);
		pAccount.getBtnOk().setEnabled(false);
		pAccount.getBtnAction().setEnabled(false);
		pt.refrashModel(TableUtil.startModel(TableUtil.BANKBOOKTRNNAMES));
		
		
		add(pt, BorderLayout.CENTER);
		
	}

}
