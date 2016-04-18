package bank.member.ljh.comf;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BankPanel.comp.ComboboxPanel;
import BankPanel.comp.InputPanel;
import BankPanel.comp.TripleBtn;
import bank.dto.Client;
import bank.member.ljh.service.ClientDeleteService;
import bank.member.ljh.service.ClientSaveService;
import bank.member.ljh.service.ClientSearchService;

public class ClientMain extends JPanel {

	
	public InputPanel pCltCode;
	public InputPanel pCltName;
	public InputPanel pCltPass;
	public ComboboxPanel pCltGrade;
	/*protected ClientMain main;

	public void setMain(ClientMain main) {
		this.main = main;
	}*/
	public ClientMain() {
		
		setLayout(new BorderLayout());
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		pCltCode = new InputPanel();
		pCltCode.getTfValue().setToolTipText("");
		pCltCode.getTfValue().setDocument(new JtextFeildLimite(4));
		pCltCode.setLblTitle("고객코드");
		panel.add(pCltCode);

		pCltName = new InputPanel();
		pCltName.setLblTitle("고객명");
		panel.add(pCltName);

		pCltPass = new InputPanel();
		pCltPass.setLblTitle("고객암호");
		pCltPass.getTfValue().setDocument(new JtextFeildLimite(4));
		panel.add(pCltPass);

		pCltGrade = new ComboboxPanel();
		pCltGrade.getCBValue().setModel(new DefaultComboBoxModel(new String[] { "선택", "H", "M", "L" }));
		pCltGrade.getCBValue().setMaximumRowCount(4);
		pCltGrade.setLblTitle("등  급");
		panel.add(pCltGrade);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));

		TripleBtn panel_6 = new TripleBtn() {

			@Override
			protected void btnSearchactionPerformed(ActionEvent e) {
				String result = JOptionPane.showInputDialog(null, "검색할 고객번호를 입력하시오", "검색", JOptionPane.QUESTION_MESSAGE)
						.trim();

				Client clt = ClientSearchService.getInstance().SearchClient(result);
				setClient(clt);
			}

			@Override
			protected void btnSaveactionPerformed(ActionEvent e) {
				try {
					Client clt = getClient();
					isValidCheck(clt);

					ClientSaveService service = ClientSaveService.getInstance();
					service.insertClient(clt);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					// e.printStackTrace();
				} finally {
					
				}
				/*
				 * ClientBtn s = new ClientBtn(); s.save(getClient());
				 */

			}

			protected void btnDeleteactionPerformed(ActionEvent e) {
				String result = JOptionPane.showInputDialog(null, "삭제할 고객번호를 입력하시오", "삭제", JOptionPane.QUESTION_MESSAGE)
						.trim();

				ClientDeleteService.getInstance().deleteClient(result);

			}
		};
		panel_1.add(panel_6);
	}

	public Client getClient() {
		String pcode = pCltCode.getTfValue().getText().trim();
		String pname = pCltName.getTfValue().getText().trim();
		String ppwd = pCltPass.getTfValue().getText().trim();
		String pgrade = (String) pCltGrade.getCBValue().getSelectedItem();

		Client clt = new Client();
		clt.setCltCode(pcode);
		clt.setCltName(pname);
		clt.setCltPass(ppwd);
		clt.setCltGrade(pgrade);
		return clt;
	}

	public void isValidCheck(Client clt) throws Exception {
		String pcode = pCltCode.getTfValue().getText().trim();
		String pname = pCltName.getTfValue().getText().trim();
		String ppwd = pCltPass.getTfValue().getText().trim();
		String pgrade = (String) pCltGrade.getCBValue().getSelectedItem();

		if (pcode.equals("") || pname.equals("") || ppwd.equals("") || pgrade.equals("")) {
			throw new Exception("빈칸이 존재합니다.");
		}
		
		char ch1 = pcode.charAt(0);

		if (!((ch1 >= 'a' && ch1 <= 'z') || (ch1 >= 'A' && ch1 <= 'Z'))) {
			throw new Exception("고객코드의 첫글자는 영문자만 가능.");
		}

		String st1 = ppwd.substring(1, 4);
		
		if ((Pattern.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣a-zA-Z]*$", pname) == false)) {
			throw new Exception("고객명에는 한글 혹은 영어만 적을수 있어요");
		}

		if (Pattern.matches("^[0-9a-zA-Z]*$", st1) == false) {
			throw new Exception("고객암호에 문자 및 숫자 외 다른 문자가 섞여있어요");
		}

		
	}

	public void clearItem() {
		pCltCode.getTfValue().setText("");
		pCltName.getTfValue().setText("");
		pCltPass.getTfValue().setText("");

	}

	public void setClient(Client clt) {
		pCltCode.getTfValue().setText(clt.getCltCode());
		pCltName.getTfValue().setText(clt.getCltName());
		pCltPass.getTfValue().setText(clt.getCltPass());
		pCltGrade.getCBValue().setSelectedItem(clt.getCltGrade());

	}

}
