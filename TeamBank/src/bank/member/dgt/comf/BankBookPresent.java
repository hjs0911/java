package bank.member.dgt.comf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import BankPanel.comp.DInputDBtnP;
import BankPanel.comp.TablePanel;
import BankPanel.jdbc.ConnectionFactory;
import bank.data.TableUtil;
import bank.dto.Employee;
import bank.main.MainFrame;
import bank.main.MainPanel;
import bank.member.dgt.dao.BankBookDao;
import bank.member.dgt.service.ListService;

public class BankBookPresent extends JPanel {
	private DInputDBtnP Dinputpanel;
	private TablePanel tablePanel;
	private DefaultTableModel model;

	public BankBookPresent() {
		setLayout(new BorderLayout(0, 0));
		setDinputpanel();
		setTablepanel();
	}

	private void setDinputpanel() {
		Dinputpanel = new DInputDBtnP() {
			@Override
			protected void btnOkactionPerformed(ActionEvent e) {
				String result = Dinputpanel.getPanelEditable().getTfValue().getText().trim();
				BankBookDao dao = BankBookDao.getInstance();
				Employee dto = dao.selectEmpName(ConnectionFactory.getConnection(), result);

				try {
					if (dto.getEmpAuth().equals("A") || dto.getEmpAuth().equals("C")) {
						Dinputpanel.getPanelNonEditable().getTfValue().setText(dto.getEmpName());
						Dinputpanel.getBtnAction().setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "사용권한이 없습니다.!");
						MainFrame.getInstance().repaintPane(new MainPanel());
					}
				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "사원코드를 입력하세요");
				}
			}

			@Override
			protected void btnActionactionPerformed(ActionEvent e) {
				model = ListService.getInstance().getRowDate();
				tablePanel.refrashModel(model);
			}
		};
		Dinputpanel.getPanelEditable().setLblTitle("사원코드");
		Dinputpanel.getPanelNonEditable().setLblTitle("사원명");
		Dinputpanel.getBtnAction().setEnabled(false);
		add(Dinputpanel, BorderLayout.NORTH);
	}

	private void setTablepanel() {
		tablePanel = new TablePanel();
		add(tablePanel, BorderLayout.CENTER);
		model = TableUtil.startModel(TableUtil.BANKBOOKTABLENAMES);
		tablePanel.refrashModel(model);
	}
}
