package bank.member.asm.comf;

import java.awt.GridLayout;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BankPanel.comp.ComboboxPanel;
import BankPanel.comp.InputPanel;
import bank.dto.Employee;

public class EmpControllerPanel extends JPanel {

	private InputPanel eEmpcodePanel;
	private InputPanel eEmpnamePanel;
	private ComboboxPanel eTitlePanel;
	private ComboboxPanel eEmpquthPanel_3;
	private EmpControllerBtn ePanel;

	public EmpControllerPanel() {

		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new GridLayout(5, 1, 0, 10));

		eEmpcodePanel = new InputPanel();
		eEmpcodePanel.setLblTitle("사원코드");
		eEmpcodePanel.getTfValue().setDocument(new JtextFeildLimite(4));
		add(eEmpcodePanel);

		eEmpnamePanel = new InputPanel();
		eEmpnamePanel.setLblTitle("사원명");
		eEmpnamePanel.getTfValue().setDocument(new JtextFeildLimite(10));
		add(eEmpnamePanel);

		eTitlePanel = new ComboboxPanel();
		eTitlePanel.setLblTitle("직급");
		eTitlePanel.getCBValue().setMaximumRowCount(5);
		eTitlePanel.getCBValue().setModel(new DefaultComboBoxModel(new String[] { "사원", "대리", "과장", "부장", "대표" }));
		add(eTitlePanel);

		eEmpquthPanel_3 = new ComboboxPanel();
		eEmpquthPanel_3.setLblTitle("권한");
		eEmpquthPanel_3.getCBValue().setModel(new DefaultComboBoxModel(new String[] { "A", "B", "C" }));
		eEmpquthPanel_3.getCBValue().setMaximumRowCount(4);
		add(eEmpquthPanel_3);

		ePanel = new EmpControllerBtn(this);
		add(ePanel);
	}

	protected Employee getcomple() {

		String ecode = eEmpcodePanel.getTfValue().getText().trim();
		String ename = eEmpnamePanel.getTfValue().getText().trim();
		String etitle = (String) eTitlePanel.getCBValue().getSelectedItem();
		String empqth = (String) eEmpquthPanel_3.getCBValue().getSelectedItem();

		Employee bank = new Employee();
		bank.setEmpCode(ecode);
		bank.setEmpName(ename);
		bank.setEmpTitle(etitle);
		bank.setEmpAuth(empqth);

		return bank;
	}

	protected void isValidCheck() throws Exception {

		String ecode = eEmpcodePanel.getTfValue().getText();
		String ename = eEmpnamePanel.getTfValue().getText();

		if (ecode.equals("") || ename.equals("")) {
			throw new Exception("빈칸이 존재합니다.");
		}
		char ch1 = ecode.charAt(0);

		if (!((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= 'A' && ch1 <= 'Z'))) {
			throw new Exception("직원코드의첫글자는영문자이어야 됩니다.");
		}

		String st1 = ecode.substring(1, 4);

		if (Pattern.matches("^[0-9a-zA-Z]*$", st1) == false) {
			throw new Exception("직원코드에영문자 및 한글 외 다른 문자가 섞여있어요");
		}

		if ((Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z]*$", ename) == false)) {
			throw new Exception("사원명에는 한글 혹은 영어만 적을수 있어요");
		}

	}

	protected Employee empty() throws Exception {
		eEmpcodePanel.getTfValue().setText("");
		eEmpnamePanel.getTfValue().setText("");
		eTitlePanel.getCBValue().setSelectedIndex(0);
		eEmpquthPanel_3.getCBValue().setSelectedIndex(0);
		Employee dao = new Employee();

		dao.setEmpCode(null);
		dao.setEmpName(null);
		dao.setEmpTitle(null);
		dao.setEmpAuth(null);
		return dao;
	}

	protected Employee degetcomple() {

		String ecode = eEmpcodePanel.getTfValue().getText().trim();
		String ename = eEmpnamePanel.getTfValue().getText().trim();

		Employee bank = new Employee();
		bank.setEmpCode(ecode);
		bank.setEmpName(ename);
		bank.setEmpTitle("");
		bank.setEmpAuth("");

		return bank;
	}

	protected Employee getdcount(Employee comp) {

		eEmpcodePanel.getTfValue().setText(comp.getEmpCode());
		eEmpnamePanel.getTfValue().setText(comp.getEmpName());
		eTitlePanel.getCBValue().setSelectedItem(comp.getEmpTitle());
		eEmpquthPanel_3.getCBValue().setSelectedItem(comp.getEmpAuth());
		return comp;

	}

}
