package bank.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bank.main.menu.DataMenu;
import bank.main.menu.MoneyMenu;
import bank.main.menu.ViewMenu;

public class MainFrame extends JFrame {
	private static final MainFrame instance=new MainFrame();

	public static MainFrame getInstance() {
		return instance;
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = MainFrame.getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600,400);
		setResizable(false);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		DataMenu mnDataMenu = new DataMenu();
		menuBar.add(mnDataMenu);
		
		MoneyMenu mnMoneyMenu = new MoneyMenu();
		menuBar.add(mnMoneyMenu);
		
		ViewMenu mnViewMenu = new ViewMenu();
		menuBar.add(mnViewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(new MainPanel());
		
	}
	public void repaintPane(JPanel jpanel){
		contentPane.removeAll();
		contentPane.add(jpanel);
		contentPane.revalidate();
		contentPane.repaint();
	}
	
}
