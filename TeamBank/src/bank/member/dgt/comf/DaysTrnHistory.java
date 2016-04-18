package bank.member.dgt.comf;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import BankPanel.comp.DInputBtnP;
import BankPanel.comp.TablePanel;
import BankPanel.jdbc.ConnectionFactory;
import bank.data.TableUtil;
import bank.dto.Employee;
import bank.main.MainFrame;
import bank.main.MainPanel;
import bank.member.dgt.dao.BankBookDao;
import bank.member.dgt.service.ListService;

public class DaysTrnHistory extends JPanel implements ActionListener {
	private DInputBtnP DinputPanel;
	private DatePanel Datepanel;
	private TablePanel Tablepanel;
	private DefaultTableModel model;
	private JPanel Norspanel;
	private String StartDay;
	private String EndDay;
	private JPanel totalpanel;
	/*private JLabel lbltotal;
	private JLabel lblIsum;
	private JLabel lblDsum;*/

	public String getStartDay() {
		return StartDay;
	}

	public void setStartDay(String startDay) {
		StartDay = startDay;
	}

	public String getEndDay() {
		return EndDay;
	}

	public void setEndDay(String endDay) {
		EndDay = endDay;
	}

	public DaysTrnHistory() {
		setLayout(new BorderLayout());
		Norspanel = new JPanel();
		Norspanel.setLayout(new GridLayout(2, 1));
		add(Norspanel, BorderLayout.NORTH);
		setDinputPanel();
		setDatepanel();
		setTablepanel();
		//setTotalPanel();
	}

	/*private void setTotalPanel() {
		totalpanel = new JPanel();
		add(totalpanel, BorderLayout.SOUTH);
		totalpanel.setLayout(new GridLayout(0, 4, 0, 0));
		lbltotal = new JLabel("합 계");
		totalpanel.add(lbltotal);
		totalpanel.add(new JLabel());
		lblIsum = new JLabel("0");
		
		totalpanel.add(lblIsum);

		lblDsum = new JLabel("0");
		
		totalpanel.add(lblDsum);
	}*/

	private void setTablepanel() {
		DefaultTableModel model = TableUtil.startModel(TableUtil.TRNNAMES);
		Tablepanel = new TablePanel();
		add(Tablepanel, BorderLayout.CENTER);
		Tablepanel.refrashModel(model);
	}

	private void setDinputPanel() {
		DinputPanel = new DInputBtnP() {
			@Override
			protected void btnOkactionPerformed(ActionEvent e) {
				String result = DinputPanel.getPanelEditable().getTfValue().getText().trim();
				BankBookDao dao = BankBookDao.getInstance();
				Employee dto = dao.selectEmpName(ConnectionFactory.getConnection(), result);
				try {
					if (dto.getEmpAuth().equals("A") || dto.getEmpAuth().equals("C")) {
						DinputPanel.getPanelNonEditable().getTfValue().setText(dto.getEmpName());
						Datepanel.getbtnAction().setEnabled(true);
					} else {

						JOptionPane.showMessageDialog(null, "사용권한이 없습니다.");
						MainFrame.getInstance().repaintPane(new MainPanel());

					}
				} catch (NullPointerException e2) {
					JOptionPane.showMessageDialog(null, "사원코드를 입력하세요");
				}
			}
		};
		DinputPanel.getPanelEditable().setLblTitle("사원코드");
		DinputPanel.getPanelNonEditable().setLblTitle("사원명");
		Norspanel.add(DinputPanel);
	}

	private void setDatepanel() {
		Datepanel = new DatePanel();
		Datepanel.getbtnAction().addActionListener(this);
		Datepanel.setLblText("검색 시작일 :");
		Datepanel.setLblSub("검색종료일 :");
		Datepanel.getbtnAction().setEnabled(false);
		Norspanel.add(Datepanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Datepanel.getbtnAction()) {
			StartDay = Datepanel.getDatePicker1().getJFormattedTextField().getText();
			EndDay = Datepanel.getDatePicker2().getJFormattedTextField().getText();

			if (StartDay.compareTo(EndDay) > 0) {
				JOptionPane.showMessageDialog(null, "검색 종료일이 검색 시작일보다 앞일수 없습니다.");
			} else {
				model = ListService.getInstance().getTrnNames(StartDay, EndDay);
				/*String[] data = ListService.getInstance().AllSum(StartDay, EndDay);
				lblIsum.setText(data[0]);
				lblDsum.setText(data[1]);*/
				Tablepanel.refrashModel(model);
			}

		}
	}
}
