package bank.main;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BankPanel.config.Config;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setLayout(new BorderLayout());
		ImageIcon main= new ImageIcon(Config.USER_DIR+"\\image\\merrychristmas.gif");
		JLabel lbl=new JLabel(main);
		add(lbl,BorderLayout.CENTER);
		
	}

}
