package bank.member.asm.comf;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;

import javax.swing.JPanel;

import BankPanel.comp.InputPanel;
import bank.dto.BankBook;
import bank.dto.Client;

public class AcountControllerPanel extends JPanel {

	private InputPanel bAccountPanel;
	private InputPanel bOpeningdatePanel;
	private InputPanel bBlancePanel;
	private ClientSerch aOkpanel2;
	private AcountControllerBtn Abtnpanel;
	private Client client;
	public AcountControllerPanel() {
		setLayout(new GridLayout(5, 1, 0, 0));

		bAccountPanel = new InputPanel();
		bAccountPanel.setLblTitle("계좌번호");
		bAccountPanel.getTfValue().setDocument(new JtextFeildLimite(7));
		add(bAccountPanel);

		aOkpanel2 = new ClientSerch(this);
		aOkpanel2.getPanelEditable().setLblTitle("고객코드");
		aOkpanel2.getPanelEditable().getTfValue().setEditable(false);
		aOkpanel2.getPanelNonEditable().setLblTitle("고객명");
	   
		
		
		add(aOkpanel2);

		bOpeningdatePanel = new InputPanel();
		bOpeningdatePanel.setLblTitle("계좌개설일");
		bOpeningdatePanel.getTfValue().setDocument(new JtextFeildLimite(10));
		bOpeningdatePanel.getTfValue().setEditable(false);
		add(bOpeningdatePanel);

		getday();

		bBlancePanel = new InputPanel();
		bBlancePanel.setLblTitle("이자율");
		bBlancePanel.getTfValue().setDocument(new JtextFeildLimite(4));
		add(bBlancePanel);

		Abtnpanel = new AcountControllerBtn(this);
		add(Abtnpanel);
	}

	protected void isValidCheck() throws Exception {
		String ccode = aOkpanel2.getPanelEditable().getTfValue().getText().trim();
		String cname = aOkpanel2.getPanelNonEditable().getTfValue().getText().trim();
		String aacountmenber1 = bAccountPanel.getTfValue().getText().trim();
		String openingdate = bOpeningdatePanel.getTfValue().getText().trim();
		String[] dates = openingdate.split("/");
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Integer.valueOf(dates[0]), Integer.valueOf(dates[1]) - 1, Integer.valueOf(dates[2]));
		Date date = cal.getTime();
		String interestrate1 = bBlancePanel.getTfValue().getText().trim();

		if (ccode.equals("") || cname.equals("") || aacountmenber1.equals("") || openingdate.equals("")
				|| interestrate1.equals("")) {
			throw new Exception("빈칸이 존재합니다.");
			
		}
		if(aacountmenber1.length()<7){
			throw new Exception("계좌번호는 7자리만 입력이 가능 합니다");
		}

		String st = ".";

		String ext = interestrate1.substring(interestrate1.indexOf(st) + st.length(), interestrate1.length());
		if (ext.length() > 1) {
			throw new Exception("이자율은 소수첫째자리까지만 입력 가능해요.");
		}

		if (Pattern.matches("^[0-9]{1}[0-9-]{0,7}$", aacountmenber1) == false) {
			throw new Exception("계좌번호는숫자와 -기호로  입력하셔야 되어야 하며 첫글자는 무조건 0-9사이 숫자여야 됨");
		}
         if(Pattern.matches("^[0-9]{1}[0-9]{0,7}$", aacountmenber1) == true){
        	 throw new Exception("계좌번호는숫자와 -기호로  입력하셔야 됩니다");
         }
         if(Pattern.matches("^[0-9]{1}[-]{0,7}$", aacountmenber1) == true){
        	 throw new Exception("확인좀 다시해보세요");
         }
         
      
      
	  
	}

	protected void setclient(Client client ) {
		aOkpanel2.getPanelEditable().getTfValue().setText(client.getCltCode());
		aOkpanel2.getPanelNonEditable().getTfValue().setText(client.getCltName());

	}

	protected BankBook getacount1(BankBook comp ) {
    		bAccountPanel.getTfValue().setText(comp.getAccountnumber());
		aOkpanel2.getPanelEditable().getTfValue().setText(comp.getCltcode());
/*		aOkpanel2.getPanelNonEditable().getTfValue().setText(client.getCltName());*/
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		bOpeningdatePanel.getTfValue().setText(sdf.format(now));
		bBlancePanel.getTfValue().setText(comp.getInterestrate());
		return comp;

	}
	
	/*protected Client getacount2(Client comp1 ) {

	aOkpanel2.getPanelNonEditable().getTfValue().setText(client.getCltName());
	
	return comp1;

}*/

	protected BankBook getacount() throws Exception {
		String ccode = aOkpanel2.getPanelEditable().getTfValue().getText().trim();
	
		String aacountmenber1 = bAccountPanel.getTfValue().getText().trim();
		String openingdate = bOpeningdatePanel.getTfValue().getText().trim();
		String[] dates = openingdate.split("/");
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Integer.valueOf(dates[0]), Integer.valueOf(dates[1]) - 1, Integer.valueOf(dates[2]));
		Date date = cal.getTime();
		String interestrate1 = bBlancePanel.getTfValue().getText().trim();

		BankBook dto = new BankBook();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		dto.setCltcode(ccode);
		/*dto.setCltname(cname);*/
		dto.setAccountnumber(aacountmenber1);
		dto.setOpeningdate(sdf.format(date));
		dto.setInterestrate(interestrate1);

		return dto;

	}
	protected void getday(){
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		bOpeningdatePanel.getTfValue().setText(sdf.format(now));
	}
	protected void clear() {
		aOkpanel2.getPanelEditable().getTfValue().setText("");
		aOkpanel2.getPanelNonEditable().getTfValue().setText("");
		bAccountPanel.getTfValue().setText("");		
		bBlancePanel.getTfValue().setText("");		
	}

	protected BankBook getcount1(BankBook comp) {

		bAccountPanel.getTfValue().setText(comp.getAccountnumber());
		aOkpanel2.getPanelEditable().getTfValue().setText(comp.getCltcode());
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		bOpeningdatePanel.getTfValue().setText(sdf.format(now));
		bBlancePanel.getTfValue().setText(comp.getInterestrate());
		return comp;

	}

	public void getgetacount2(String str2) {

		aOkpanel2.getPanelNonEditable().getTfValue().setText(str2);
	}

}
