package bank.member.asm.comf;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import BankPanel.comp.TripleBtn;
import BankPanel.jdbc.ConnectionFactory;
import bank.dto.Employee;
import bank.member.asm.dao.BankDao;
import bank.member.asm.service.EmpDeletService;
import bank.member.asm.service.EmpInputService;

public class EmpControllerBtn extends TripleBtn {
	EmpControllerPanel cp;

	public EmpControllerBtn(EmpControllerPanel cp) {
		super();
		this.cp = cp;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void btnSaveactionPerformed(ActionEvent e) {

		try {
			cp.isValidCheck();
			Employee ccd = cp.getcomple();
			EmpInputService service = EmpInputService.getinstance();
			service.insertcomplet(ccd);
			Employee comp = cp.empty();
		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, e1.getMessage());

		}
	}

	@Override
	protected void btnDeleteactionPerformed(ActionEvent e) {
		String result = JOptionPane.showInputDialog(null, "사원코드를 입력하세요", "고객입력", JOptionPane.INFORMATION_MESSAGE)
				.trim();
		BankDao dao = BankDao.getinstance();
		try {
			Employee sub = dao.EmpSerch(ConnectionFactory.getConnection(), result);
			Employee ccd = cp.getcomple();
			EmpDeletService service = EmpDeletService.getInstance();
			service.EmpDelet(sub);

			Employee comp = cp.empty();

		} catch (Exception e1) {

			JOptionPane.showMessageDialog(null, e1.getMessage());

			// e1.printStackTrace();

		} finally {

		}

	}

	@Override
	protected void btnSearchactionPerformed(ActionEvent e) {

		String result = JOptionPane.showInputDialog(null, "검색할 직원을 입력하세요", "고객입력", JOptionPane.INFORMATION_MESSAGE)
				.trim();
		BankDao dao = BankDao.getinstance();
		try {

			Employee sub = dao.EmpSerch(ConnectionFactory.getConnection(), result);
			cp.getdcount(sub);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "직원이존재하지 않습니다", "오류 메시지", JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		}

	}

}
