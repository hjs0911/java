import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.*;

public class MCalendar extends JPanel implements ItemListener,ActionListener{
	private static final long serialVersionUID = 1L;
	private JButton[] dayB = new JButton[7];
	private JButton[] weekdayB = new JButton[42];
	private JLabel labelYearMonth = new JLabel(" ");
	private JComboBox<Integer> comboYear;
	private JComboBox<Integer> comboMonth;
	private JPanel calendarPanel;
	private Calendar nowDaySelcetDay;
	private Calendar endDay;
	private	int todayYear;
	private	int todayMonth;
	private	int todayday;
	private String stringDate;
	private int selectYear;
	private int selectMonth;
	private int selectDay;
	private JPanel acountbookP;
	private JLabel labelSelectDay;
	private JTextArea acountbookBody;	
	private JPanel totalP;	
	public MCalendar() {
		//�޷���Ʈ
		calendarPanel=new JPanel();
		calendarPanel.setLayout(new BorderLayout());
		JPanel cPanel=new JPanel();
		String days="�Ͽ�ȭ�������";
		cPanel.setLayout(new GridLayout(7, 7));
		for(int i=0;i<7;i++){
			dayB[i]=new JButton(days.charAt(i)+"");
			cPanel.add(dayB[i]);
		}
		for(int i=0;i<42;i++){
			weekdayB[i]=new JButton("");
			cPanel.add(weekdayB[i]);
			weekdayB[i].addActionListener(this);
		}
		JPanel date=new JPanel();
		comboYear=new JComboBox<>();
		nowDaySelcetDay=Calendar.getInstance();
		Date currentDate=new Date();
		SimpleDateFormat fomatter=new SimpleDateFormat("EEE MMM dd hh:mm:ss yyyy",Locale.getDefault());
		fomatter.applyPattern("y");
		try{
			todayYear=Integer.parseInt(fomatter.format(currentDate));
		}catch(NumberFormatException n){
			todayYear=0;
		}
		selectYear=todayYear;
		fomatter.applyPattern("M");
		try{
			todayMonth=Integer.parseInt(fomatter.format(currentDate));
		}catch(NumberFormatException n){
			todayMonth=0;
		}
		selectMonth=todayMonth;
		fomatter.applyPattern("d");
		try{
			todayday=Integer.parseInt(fomatter.format(currentDate));
		}catch(NumberFormatException n){
			todayday=0;
		}
		selectDay=todayday;
		for(int i=0;i<=(todayYear-2015);i++){
			comboYear.addItem(todayYear-i);
		}
		comboMonth=new JComboBox<>();
	    for(int i=1;i<=12;i++)
	    	comboMonth.addItem(i);
	    date.add(comboYear);
	    date.add(new JLabel("��"));
	    date.add(comboMonth);
	    date.add(new JLabel("��"));
	    comboMonth.setSelectedIndex(todayMonth-1);	   
	    makeCalendar();
	    comboYear.addItemListener(this);
	    comboMonth.addItemListener(this);
	    calendarPanel.add(labelYearMonth,BorderLayout.NORTH);
	    calendarPanel.add(cPanel,BorderLayout.CENTER);
	    calendarPanel.add(date,BorderLayout.SOUTH);
	    //�޷���Ʈ ��
	    acountbookP=new JPanel();
		acountbookP.setLayout(new BorderLayout());
		labelSelectDay=new JLabel();
		labelSelectDay.setText(getselYear()+"��"+getselMonth()+"��"+getselday()+"��"+"����");
		acountbookP.add(labelSelectDay,BorderLayout.NORTH);		
		acountbookBody=new JTextArea(20,15);
		String jbt=selectDay+"";		
		setStringDate(jbt);
		acountbookBody.setText(new MakeString(stringDate).getStr());		
		acountbookBody.setEditable(false);
		acountbookP.add(acountbookBody,BorderLayout.CENTER);
		totalP=new JPanel(new GridLayout(1, 2));
		totalP.add(calendarPanel);
		totalP.add(acountbookP);
	}
	public void setTodayJl() {		
		this.labelSelectDay.setText(todayYear+"��"+todayMonth+"��"+todayday+"��"+"����");
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		makeCalendar();		
	}
	public void makeCalendar(){
		selectYear=todayYear-comboYear.getSelectedIndex();
		selectMonth=comboMonth.getSelectedIndex()+1;
		nowDaySelcetDay.set(selectYear,selectMonth-1, 1);
		endDay = Calendar.getInstance();
	    endDay.set(selectYear,selectMonth, 1);
	    endDay.add(Calendar.DATE, -1);
	    int ��������¥ = endDay.get(Calendar.DATE);	  
	    int �����ε��� = nowDaySelcetDay.get(Calendar.DAY_OF_WEEK);
	    for(int i=0,j=1;i<42;i++){
	    	if(i<�����ε���-1){
	    		weekdayB[i].setText("");	    	 
	    	}
	    	else if(j>��������¥){
	    		weekdayB[i].setText("");	    	 
	    	}
	    	else{
	    		weekdayB[i].setText(j++ +"");
	    	}
	    }
	    labelYearMonth.setText(selectYear+"�� "+selectMonth+"��");
	}
	@Override
	public void actionPerformed(ActionEvent e){
		
		JButton jb=(JButton)e.getSource();
		String jbt=jb.getText();
		
		if(jbt.equals("")){
			
		}		
		else{			
			setStringDate(jbt);		
			labelSelectDay.setText(getselYear()+"��"+getselMonth()+"��"+getselday()+"��"+"����");			
			acountbookBody.setText(new MakeString(stringDate).getStr());
		}		
	}

	public void setStringDate(String stringDay){
		selectDay=Integer.parseInt(stringDay);
		if(selectDay/10==0){
			stringDay=0+stringDay;
		}
		if(selectMonth/10==0){
			stringDay=0+""+selectMonth+stringDay;
		}
		else
			stringDay=selectMonth+stringDay;
		stringDay=selectYear+stringDay;
		stringDate=stringDay;
	}
	public int getselday() {
		return selectDay;
	}
	public int getselYear() {
		return selectYear;
	}
	public int getselMonth() {
		return selectMonth;
	}
	public void setJta(String jta) {
		this.acountbookBody.setText(jta);
	}
	public JPanel getTotalP() {
		return totalP;
	}	
}
