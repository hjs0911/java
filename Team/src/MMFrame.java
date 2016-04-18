import javax.swing.*;

import java.awt.event.*;
import java.awt.*;
public class MMFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	private JMenuBar jmb;
	private JMenu jm;
	private JMenuItem jmi1;
	private JMenuItem jmi2;
	private Container c;
	private MCalendar mcd;
	private CCPanel ccp;
	private CardLayout cards;
	private JPanel con;	
	public MMFrame(Data dat){
		super("Ä«¿îÅÍ");
		jmb=new JMenuBar();
		jm=new JMenu("È­¸éÁ¾·ù");
		jmi1=new JMenuItem("È¦");
		jmi2=new JMenuItem("ÀåºÎ");
		jmb.add(jm);
		jm.add(jmi1);
		jm.add(jmi2);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		cards=new CardLayout();
		c=getContentPane();		
		con=new JPanel();
		con.setLayout(cards);
		ccp=new CCPanel(dat);
		mcd=new MCalendar();
		con.add("È¦",ccp.getTotalPanel());
		con.add("ÀåºÎ",mcd.getTotalP());
		c.add(jmb,BorderLayout.NORTH);
		c.add(con,BorderLayout.CENTER);		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 String s = e.getActionCommand();
		if(s=="È¦"){			
			cards.show(con,"È¦");			
		}
		if(s=="ÀåºÎ"){
			cards.show(con, "ÀåºÎ");
			mcd.setTodayJl();
			mcd.setJta(new MakeString().getStr());			
		}
	}	
}
