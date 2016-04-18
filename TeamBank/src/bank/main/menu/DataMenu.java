package bank.main.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import bank.main.MainFrame;
import bank.member.asm.comf.AcountControllerPanel;
import bank.member.asm.comf.EmpControllerPanel;
import bank.member.ljh.comf.ClientMain;

public class DataMenu extends JMenu implements ActionListener {
	private JMenuItem mntmEmp;
	private JMenuItem mntmClt;
	private JMenuItem mntmBbook;
	public DataMenu() {
		setText("기초자료관리");
		
		mntmEmp = new JMenuItem("사원관리");
		mntmEmp.addActionListener(this);
		add(mntmEmp);
		
		mntmClt = new JMenuItem("고객관리");
		mntmClt.addActionListener(this);
		add(mntmClt);
		
		mntmBbook = new JMenuItem("통장관리");
		mntmBbook.addActionListener(this);
		add(mntmBbook);
	}
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmBbook) {
			mntmBbook_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmClt) {
			mntmClt_actionPerformed(arg0);
		}
		if (arg0.getSource() == mntmEmp) {
			mntmEmp_actionPerformed(arg0);
		}
	}
	protected void mntmEmp_actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().repaintPane(new EmpControllerPanel());
	}
	protected void mntmClt_actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().repaintPane(new ClientMain());
	}
	protected void mntmBbook_actionPerformed(ActionEvent arg0) {
		MainFrame.getInstance().repaintPane(new AcountControllerPanel());
	}
}
