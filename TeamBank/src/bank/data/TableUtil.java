package bank.data;

import javax.swing.table.DefaultTableModel;

public class TableUtil {
	public static final String[] BANKBOOKTABLENAMES = { "계좌번호", "고객코드", "고객명", "계좌개설일", "이자율", "잔액" };
	public static final String[] TRNNAMES = { "거래일", "계좌번호", "입금", "출금" };
	public static final String[] CLTNAMES = { "고객코드", "고객암호", "고객명", "등급" };
	public static final String[] BANKBOOKTRNNAMES = { "거래일", "입금", "출금", "잔액" };
	public static DefaultTableModel startModel(String[] tableNames){
		return new DefaultTableModel(tableNames,0);		
	}
}
