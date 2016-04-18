package bank.member.asm.comf;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import BankPanel.comp.TripleBtn;
import BankPanel.jdbc.ConnectionFactory;
import bank.dto.BankBook;
import bank.member.asm.dao.BankDao;
import bank.member.asm.service.AcountDeletService;
import bank.member.asm.service.AcountInputService;

public class AcountControllerBtn extends TripleBtn   {

	AcountControllerPanel ap;

	public AcountControllerBtn(AcountControllerPanel ap) {
		super();
		this.ap = ap;

	}

	@Override
	protected void btnSaveactionPerformed(ActionEvent e) {

		try {
			ap.isValidCheck();
			BankBook ccd = ap.getacount();
			AcountInputService service = new AcountInputService();
			service.AcountInsert(ccd);
			/* ap.acounteqls(); */

		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage());

		} finally {
			ap.clear();			
		}

	}

	@Override
	protected void btnDeleteactionPerformed(ActionEvent e) {
		String result = JOptionPane.showInputDialog(null, "삭제할계좌번호를 입력하세요", "고객입력", JOptionPane.INFORMATION_MESSAGE)
				.trim();
		BankDao dao = BankDao.getinstance();
		try {
			BankBook sub = dao.Aserchclient(ConnectionFactory.getConnection(), result);
			ap.getacount1(sub);
			AcountDeletService AcountDeletservice = new AcountDeletService();
			AcountDeletservice.AcountDelet(sub);

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "계좌가존재하지 않습니다", "오류 메시지", JOptionPane.ERROR_MESSAGE);
		} finally {
			ap.clear();			
		}

	}

	@Override
	protected void btnSearchactionPerformed(ActionEvent e) {
		String result = JOptionPane.showInputDialog(null, "검색할계좌번호를 입력하세요", "고객입력", JOptionPane.INFORMATION_MESSAGE)
				.trim();
		BankDao dao = BankDao.getinstance();
		try {
			BankBook sub = dao.Aserchclient(ConnectionFactory.getConnection(), result);
		     String str2= dao.cltname();
		     ap.getgetacount2(str2);
			ap.getacount1(sub);

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "계좌가존재하지않습니다", "오류 메시지", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}

	}
}
