package bank.member.asm.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import BankPanel.jdbc.ConnectionFactory;
import bank.dto.BankBook;
import bank.member.asm.dao.BankDao;

public class AcountInputService {
private static  final AcountInputService instance = new AcountInputService();

public static AcountInputService getInstance() {
	return instance;
}

public  void Ainputservice(BankBook ccp){
 
	
}

public void AcountInsert(BankBook ccd) {
	try{
	Connection con = ConnectionFactory.getConnection();
	BankDao dao = BankDao.getinstance();
	int result = dao.AcountInsert(con, ccd);
	if (result > 0)
		JOptionPane.showMessageDialog(null, "계좌가 생성되었습니다");
	
} catch (SQLException e1) {
	if (e1.getErrorCode() == 1062)
		JOptionPane.showMessageDialog(null, " 계좌번호 중복 ");
	else
		e1.printStackTrace();
} 
}}