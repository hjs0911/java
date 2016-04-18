package bank.member.ljh.comf;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import BankPanel.comp.ComboboxPanel;
import BankPanel.comp.InputPanel;
import BankPanel.jdbc.ConnectionFactory;
import bank.dto.BankBook;
import bank.dto.Client;
import bank.dto.Employee;
import bank.dto.TrnHistory;
import bank.member.ljh.service.PayAndDrawInputService;
import bank.member.ljh.service.PayAndDrawSelectService;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JLabel;

public class PayAndDrawMain extends JPanel implements ActionListener {

	private ComboboxPanel pDealType;
	public InputPanel pDealName;
	private InputPanel pEmpCode;
	private InputPanel pEmpName;
	private InputPanel pAccountNum;
	private InputPanel pCltname;
	private InputPanel pCltpass;
	public InputPanel pDealDate;
	public InputPanel pMoney;
	private JButton btnCodeOk;
	private JButton btnNumOk;
	private JButton btnPassOk;
	private JButton btnSaveOk;
	private Client passBox;
	private BankBook bb = new BankBook();
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel label;

	public PayAndDrawMain() {
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		pEmpCode = new InputPanel();
		pEmpCode.setAlignmentY(Component.CENTER_ALIGNMENT);
		pEmpCode.setLblTitle("사원코드");
		panel.add(pEmpCode);

		pEmpName = new InputPanel();
		pEmpName.setAlignmentY(Component.CENTER_ALIGNMENT);
		pEmpName.setLblTitle("사원명");
		panel.add(pEmpName);
		pEmpName.getTfValue().setEditable(false);

		btnCodeOk = new JButton("확인");
		btnCodeOk.addActionListener(this);
		panel.add(btnCodeOk);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(panel);
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.X_AXIS));

		pAccountNum = new InputPanel();
		pAccountNum.setAlignmentY(Component.CENTER_ALIGNMENT);
		pAccountNum.setLblTitle("계좌번호");
		panel_3.add(pAccountNum);

		pCltname = new InputPanel();
		pCltname.setAlignmentY(Component.CENTER_ALIGNMENT);
		pCltname.setLblTitle("고객명");
		panel_3.add(pCltname);
		pCltname.getTfValue().setEditable(false);

		btnNumOk = new JButton("확인");
		btnNumOk.addActionListener(this);
		panel_3.add(btnNumOk);

		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		pCltpass = new InputPanel();
		pCltpass.setAlignmentY(Component.CENTER_ALIGNMENT);
		pCltpass.setLblTitle("고객암호");
		panel_4.add(pCltpass);

		btnPassOk = new JButton("확인");
		btnPassOk.addActionListener(this);
		panel_4.add(btnPassOk);
		
		panel_7 = new JPanel();
		panel_4.add(panel_7);
		panel_7.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel panel_5 = new JPanel();
		panel_1.add(panel_5);

		pDealType = new ComboboxPanel();
		pDealType.getCBValue().addActionListener(this);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		pDealType.getCBValue().setModel(new DefaultComboBoxModel(new String[] { "선택", "I", "D" }));
		pDealType.setLblTitle("거 래 종 류");
		panel_5.add(pDealType);

		pDealName = new InputPanel();
		pDealName.setAlignmentY(Component.CENTER_ALIGNMENT);
		pDealName.setLblTitle("거   래   명");
		panel_5.add(pDealName);
		pDealName.getTfValue().setEditable(false);
		
		panel_11 = new JPanel();
		panel_5.add(panel_11);
		
		label = new JLabel("                                      ");
		panel_11.add(label);

		JPanel panel_6 = new JPanel();
		panel_1.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));

		pDealDate = new InputPanel();
		pDealDate.setLblTitle("거래일자");
		panel_6.add(pDealDate);
		pDealDate.getTfValue().setEditable(false);

		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		pDealDate.getTfValue().setText(sdf.format(now));
		
		panel_10 = new JPanel();
		panel_6.add(panel_10);
				
				panel_8 = new JPanel();
				panel_1.add(panel_8);
						panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.X_AXIS));
				
						pMoney = new InputPanel();
						panel_8.add(pMoney);
						pMoney.setLblTitle("금     액");
						
						panel_9 = new JPanel();
						panel_8.add(panel_9);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_2, BorderLayout.SOUTH);

		btnSaveOk = new JButton("저장");
		btnSaveOk.addActionListener(this);
		btnSaveOk.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnSaveOk);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSaveOk) {
			btnSaveOkActionPerformed(e);
		}
		if (e.getSource() == pDealType.getCBValue()) {
			pDealTypeCBValueActionPerformed(e);
		}
		if (e.getSource() == btnPassOk) {
			btnPassOkActionPerformed(e);
		}
		if (e.getSource() == btnNumOk) {
			btnNumOkActionPerformed(e);
		}
		if (e.getSource() == btnCodeOk) {
			btnCodeOkActionPerformed(e);
		}
	}

	protected Employee btnCodeOkActionPerformed(ActionEvent e) {
		try {

			Employee emp = new Employee();
			emp = PayAndDrawSelectService.getInstance()
					.SelectEmployee(pEmpCode.getTfValue().getText().toString().trim());
			setEmployee(emp);

		} catch (Exception e1) {

			// e.printStackTrace();
		} finally {

		}
		return null;
	}

	public void clearItem() {
		pEmpCode.getTfValue().setText("");
		pEmpName.getTfValue().setText("");
		pDealType.getCBValue().setSelectedIndex(0);
		pDealName.getTfValue().setText("");
		pAccountNum.getTfValue().setText("");
		pCltname.getTfValue().setText("");
		pCltpass.getTfValue().setText("");
		pMoney.getTfValue().setText("");
	}

	public void setEmployee(Employee emp) {

		pEmpName.getTfValue().setText(emp.getEmpName());

	}

	protected Client btnNumOkActionPerformed(ActionEvent e) {
		Client clt = new Client();
		try {

			clt = PayAndDrawSelectService.getInstance()
					.SelectClient(pAccountNum.getTfValue().getText().toString().trim());

			/*
			 * Client clt =
			 * EmployeeDao.getIntance().selectCltNameByAccountNum(con,
			 * pAccountNum.getTfValue().getText().toString().trim());
			 */

			setClient(clt);
			passBox = new Client();
			passBox.setCltPass(clt.getCltPass());

		} catch (Exception e1) {

			// e.printStackTrace();
		} finally {

		}
		return clt;

	}

	private void setClient(Client clt) {
		pCltname.getTfValue().setText(clt.getCltName());

	}

	protected Client btnPassOkActionPerformed(ActionEvent e) {

		if (pCltpass.getTfValue().getText().toString().trim().equals(passBox.getCltPass())) {
			JOptionPane.showMessageDialog(null, "인증성공");
		} else {
			JOptionPane.showMessageDialog(null, "인증실패");
			pCltpass.getTfValue().setText("");
		}
		return null;
	}

	protected void pDealTypeCBValueActionPerformed(ActionEvent e) {
		if (pDealType.getCBValue().getModel().getSelectedItem().equals("I")) {
			pDealName.getTfValue().setText("입금");
		} else if (pDealType.getCBValue().getModel().getSelectedItem().equals("D")) {
			pDealName.getTfValue().setText("출금");
		} else {
			pDealName.getTfValue().setText("");
		}
	}

	protected void btnSaveOkActionPerformed(ActionEvent e) {

		String inter = pMoney.getTfValue().getText().trim();

		try {
			isValidCheck();
			bb = PayAndDrawSelectService.getInstance()
					.SelectBalance(pAccountNum.getTfValue().getText().toString().trim());
			int pbalance = Integer.parseInt(bb.getBalance());
			int pmoney = Integer.parseInt(pMoney.getTfValue().getText().trim());
			if (Integer.parseInt(inter) < 0) {
				JOptionPane.showMessageDialog(null, "양수만가능");
			} else if (pDealName.getTfValue().getText().toString().equals("출금") && pmoney > pbalance) {
				JOptionPane.showMessageDialog(null, "출금불가");
			} else if (pDealName.getTfValue().getText().toString().equals("입금")) {
				pbalance = pbalance + pmoney;
				JOptionPane.showMessageDialog(null, "입금 되었습니다.");
				
				PayAndDrawInputService.getInstance().inputBalance(pAccountNum.getTfValue().getText().toString().trim(),
						pbalance);
				PayAndDrawInputService.getInstance().inputData(getTrnHistroy(), pbalance);
				clearItem();
			} else if (pDealName.getTfValue().getText().toString().equals("출금")) {
				pbalance = pbalance - pmoney;
				JOptionPane.showMessageDialog(null, "출금 되었습니다.");
				
				PayAndDrawInputService.getInstance().inputBalance(pAccountNum.getTfValue().getText().toString().trim(),
						pbalance);
				PayAndDrawInputService.getInstance().inputData(getTrnHistroy(), pbalance);
				clearItem();
			}

			// EmployeeDao.getIntance().insertData(ConnectionFactory.getConnection(),
			// getTrnHistroy());

		} catch (NumberFormatException e2) {
			JOptionPane.showMessageDialog(null, "정수만 가능");
			e2.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private TrnHistory getTrnHistroy() {
		String empcode = pEmpCode.getTfValue().getText().toString().trim();
		String accountnum = pAccountNum.getTfValue().getText().toString().trim();
		String dealtype = (String) pDealType.getCBValue().getModel().getSelectedItem();
		String dealdate = pDealDate.getTfValue().getText().toString().trim();
		String money = pMoney.getTfValue().getText().toString().trim();

		TrnHistory th = new TrnHistory();
		th.setEmpCode(empcode);
		th.setAccountnumber(accountnum);
		th.setTrntype(dealtype);
		th.setTrndate(dealdate);
		th.setTrnmoney(money);
		return th;
	}

	protected void isValidCheck() throws Exception {
		String empcode = pEmpCode.getTfValue().getText().toString().trim();
		String empname = pEmpName.getTfValue().getText().trim();
		String accountnum = pAccountNum.getTfValue().getText().trim();
		String cltname = pCltname.getTfValue().getText().trim();
		String cltpass = pCltpass.getTfValue().getText().toString().trim();
		String dealtype = (String) pDealType.getCBValue().getModel().getSelectedItem();
		String dealname = pDealName.getTfValue().getText().trim();
		String dealdate = pDealDate.getTfValue().getText().trim();
		String money = pMoney.getTfValue().getText().trim();

		if (empcode.equals("") || empname.equals("") || accountnum.equals("") || cltname.equals("")
				|| cltpass.equals("") || dealtype.equals("") || dealname.equals("") || dealname.equals("")
				|| dealdate.equals("") || money.equals("")) {
			JOptionPane.showMessageDialog(null, "빈칸이 존재합니다.");
			throw new Exception("빈칸존재");
		}

	}
}
