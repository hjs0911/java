package bank.main.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import bank.main.MainFrame;
import bank.member.dgt.comf.BankBookPresent;
import bank.member.dgt.comf.DaysTrnHistory;
import bank.member.hjs.comf.info.Info;
import bank.member.hjs.comf.info.InfoEmp;
import bank.member.yjy.comf.NineMain;
import bank.member.yjy.comf.SevenMain;

public class ViewMenu extends JMenu implements ActionListener {
	private JMenuItem mntmEmpView;
	private JMenuItem mntmCltView;
	private JMenuItem mntmBBookView;
	private JMenuItem mntmBBookHistory;
	private JMenuItem mntmDayHistory;
	public ViewMenu() {
		setText("조회업무");
		
		mntmEmpView = new JMenuItem("사원현황");
		mntmEmpView.addActionListener(this);
		add(mntmEmpView);
		
		mntmCltView = new JMenuItem("고객현황");
		mntmCltView.addActionListener(this);
		add(mntmCltView);
		
		mntmBBookView = new JMenuItem("통장현황");
		mntmBBookView.addActionListener(this);
		add(mntmBBookView);
		
		mntmBBookHistory = new JMenuItem("통장별 거래내역");
		mntmBBookHistory.addActionListener(this);
		add(mntmBBookHistory);
		
		mntmDayHistory = new JMenuItem("일별 거래내역");
		mntmDayHistory.addActionListener(this);
		add(mntmDayHistory);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmDayHistory) {
			mntmDayHistory_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmBBookHistory) {
			mntmBBookHistory_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmBBookView) {
			mntmBBookView_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmCltView) {
			mntmCltView_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmEmpView) {
			mntmEmpView_actionPerformed(arg0);
		}
	}
	protected void mntmEmpView_actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().repaintPane(new Info());
	}
	protected void mntmCltView_actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().repaintPane(new SevenMain());
	}
	protected void mntmBBookView_actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().repaintPane(new BankBookPresent());		
	}
	protected void mntmBBookHistory_actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().repaintPane(new NineMain());	
	}
	protected void mntmDayHistory_actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().repaintPane(new DaysTrnHistory());		
	}
}
