package bank.main.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import bank.main.MainFrame;
import bank.member.dgt.comf.BankBookPresent;
import bank.member.hjs.comf.inter.Interest;
import bank.member.ljh.comf.PayAndDrawMain;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoneyMenu extends JMenu implements ActionListener {
	private JMenuItem mntmMoney;
	private JMenuItem mntmInter;
	public MoneyMenu() {
		setText("예금관리");
		
		mntmMoney = new JMenuItem("입출금관리");
		mntmMoney.addActionListener(this);
		add(mntmMoney);
		
		mntmInter = new JMenuItem("이자계산");
		mntmInter.addActionListener(this);
		add(mntmInter);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmInter) {
			mntmInteractionPerformed(e);
		}
		if (e.getSource() == mntmMoney) {
			mntmMoneyactionPerformed(e);
		}
	}
	protected void mntmMoneyactionPerformed(ActionEvent e) {
		MainFrame.getInstance().repaintPane(new PayAndDrawMain());	
	}
	protected void mntmInteractionPerformed(ActionEvent e) {
		MainFrame.getInstance().repaintPane(new Interest());	
	}
}
