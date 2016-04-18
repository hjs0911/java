package bank.member.dgt.comf;

import java.awt.GridLayout;
import java.util.Properties;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;

public class DatePanel extends JPanel {
	private static final DatePanel instance = new DatePanel();
	private JLabel lblText;
	private JDatePickerImpl datePicker1;
	private JDatePickerImpl datePicker2;
	JPanel Datepanel_1;
	private JPanel Datepanel_2;
	private JLabel lblSub;
	private JPanel panel_2;
	private JButton btnAction;

	public DatePanel() {
		Properties prop = new Properties();
		prop.setProperty("text.today", "\uc624\ub298");
		prop.setProperty("text.month", "\uc6d4");
		prop.setProperty("text.year", "\ub144");
		UtilDateModel model1 = new UtilDateModel();
		UtilDateModel model2 = new UtilDateModel();
		model1.setSelected(true);		
		model2.setSelected(true);		
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, prop);
		JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, prop);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		Datepanel_1 = new JPanel();		
		Datepanel_1.setLayout(new GridLayout(0, 2, 0, 0));
		lblText = new JLabel("검색 시작일");
		lblText.setVerticalAlignment(SwingConstants.TOP);
		Datepanel_1.add(lblText);
		lblText.setHorizontalAlignment(SwingConstants.RIGHT);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		Datepanel_1.add(datePicker1);
		add(Datepanel_1);
		Datepanel_2 = new JPanel();		
		Datepanel_2.setLayout(new GridLayout(0, 2, 0, 0));
		lblSub = new JLabel("검색 종료일");
		lblSub.setVerticalAlignment(SwingConstants.TOP);
		lblSub.setHorizontalAlignment(SwingConstants.RIGHT);
		Datepanel_2.add(lblSub);
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
		Datepanel_2.add(datePicker2);
		add(Datepanel_2);
		panel_2 = new JPanel();
		btnAction = new JButton("실행");
		btnAction.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(btnAction);
		add(panel_2);
	}

	public void setLblText(String label) {
		this.lblText.setText(label);
	}

	public void setLblSub(String label) {
		this.lblSub.setText(label);
	}

	public JDatePickerImpl getDatePicker1() {
		return datePicker1;
	}

	public JDatePickerImpl getDatePicker2() {
		return datePicker2;
	}

	public JButton getbtnAction() {
		return btnAction;
	}

}