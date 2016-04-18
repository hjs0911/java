import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
public class CCPanel extends JPanel implements ActionListener{
 private static final long serialVersionUID = 1L; 
 private String[] title=new String[3];
 private String[][][] data=new String[9][8][3];//�� ���̺��� �޴��� ����  ������ �ݾ���  ���� �ϱ� ���ؼ� 3���� �� ����
 private JButton[] tableB=new JButton[9];  //���̺� ��ư�� ��� �ϱ� ���ؼ�  ��ư 9���� ������ ��ư �迭�� ����� 
 private JButton[] menuB=new JButton[8];
 private JTextField[][] counts=new JTextField[8][2];//+-��ư���� �ؽ�Ʈ �ʵ带 ����� ���ؼ�  8�� 2���� ���� 2���� �ý�Ʈ �ʵ带 ����  
 private JButton[] plusB=new JButton[8];
 private JButton[] minusB=new JButton[8];//�޴� ��ư 8���� ���� �ϱ� ���ؼ� 8�� ũ����   jbutton�迭 ����
 private JTextField finalMoney=new JTextField("0",10);//ũ�Ⱑ 10�� �ؽ�Ʈ �ʵ带 ����
 private JButton calculate=new JButton("���");//�Ի����ϱ� ���� j��ư�� ����
 private JPanel totalPanel=new JPanel();
 private int tableNum=0;// ��� ���̺������� �˱� ���ؼ� ������ ������ ����
 private JPanel leftPanel=new JPanel();//�� ���̺��� ��ư��     �޴����� ���� �� �հ� �� �d�� �ݾ׵��� �߰� �Ʊ� ���ؼ� jpanel ����
 private JPanel leftPulsRightPanel=new JPanel();
 private final String[] MENUNAME={"�������","�߰��","�Ұ��","ġŲ","����","���","�Ƚ�","����"};
 private final int[] MENUMONEY={4000,3000,5000,6000,4000,3000,2000,7000};  //�޴����� ���� �� ������ ������ MENUMONEY�迭 ����� ���� 
 private JPanel receiptPanel=new JPanel(); // �� �հ踦 ����ϴ� �ؽ�Ʈ �ʵ��  �޴����� �ֹ��� �͵��� ���� �ִ� �ؽ�Ʈ ���� �߰� �ϱ� ���ؼ�   j panel ����
 private JTextField textTableNum=new JTextField();//�ع��� ���̺��� ��� �ϱ� ���ؼ� text�ʵ带 ����
 private JTextArea textReceiptArea=new JTextArea(); //�� �޴�����  �ֹ��� �� ����    �޴��� �հ� �ݾ��� �˱� ���ؼ� textarea�ʵ带 ����
 private Data dat; //date��ü�� ����
 public CCPanel(Data dt) {
  setDat(dt);
  for(int i=0;i<8;i++){
   if(!(dat.getMenuName()[i].equals(MENUNAME[i]))){
    dat.getMenuName()[i]=MENUNAME[i];
   }
  }
  try{
   new FileManager().save(dat);
  }
  catch(IOException e){
   System.out.println("tlfvo");
  }
  title[0]="�ֹ�";
  title[1]="����";
  title[2]="�ݾ�";
  for(int i=0;i<data.length;i++){//�������� Ʈ�� ���� �ݺ� �ϸ鼭 for�� ����
   for(int j=0;j<data[i].length;j++){
    data[i][j][0]=dat.getMenuName()[j];    //���̺� ����       �޴�����  �ҷ����� ����
    data[i][j][1]="0";  // ���� �ʰ�ȭ
    data[i][j][2]="0";  // �ݾ� �ʱ�ȭ
   }
  }
  for(int i=0;i<counts.length;i++){
   for(int j=0;j<counts[1].length;j++){
    counts[i][j]=new JTextField("0",4);  // �޴� ��ư�� +-��ư ���� �ؽ�Ʈ �ʵ带 ���� �ϱ� ���ؼ� 2���� �迭�� ����
    
   }
  }
  for(int i=0;i<menuB.length;i++){
   menuB[i]=new JButton(dat.getMenuName()[i]);//�޴���ư�� ���� �ϰ� �׼� ȿ���� �ֱ� ���ؼ� 
   menuB[i].addActionListener(this);// ��ư �������� ȿ���� �ֱ� ���� ���
  }
  for(int i=0;i<tableB.length;i++){//���̺���  ��ư�� ���� �ϱ� ���ؼ� 
   tableB[i]=new JButton((i+1)+"�� ���̺�");  //  �� ��ư �迭�� ����  1,2,3,4,5,6,7,8,9��� �̸��� ���� ��ư���� �����Ѵ�
   tableB[i].addActionListener(this);// ��ư ���� ȿ���� �ֱ� ���ؼ� ���
  }
  for(int i=0;i<plusB.length;i++){  //���� �߰� �ֹ��� �ϱ� ���ؼ� plusB��ư �迭�� ������   �迭����  ��ư�� ����
   plusB[i]=new JButton("+"); //plubs��� ��ư�� �迭�� +��� �̸��� ���� ��ư 8���� ����  ���� ��ŭ�߰� �ϱ� ���ؼ�
   plusB[i].addActionListener(this);// ��ư ���� ȿ���� �ֱ� ���ؼ� ���
  }
  for(int i=0;i<plusB.length;i++){
   minusB[i]=new JButton("-");   //�߰� �ֹ��Ѱſ��� ������ ���� ���ؼ�  minusB��ư �迭�� ������ �迭���� -�̸���  ���� ��ư ����
   minusB[i].addActionListener(this);//��ư ȿ���� ����ϱ� ���ؼ� ���
  }
  textTableNum.setEditable(false);
  textReceiptArea.setEditable(false);
  finalMoney.setEditable(false);
  calculate.addActionListener(this);
  receiptPanel.setLayout(new BorderLayout());
  receiptPanel.add(textTableNum(),BorderLayout.NORTH);
  receiptPanel.add(textReceiptArea(),BorderLayout.CENTER);
  receiptPanel.add(panelReceiptCalculation(), BorderLayout.SOUTH);
  leftPanel.setLayout(new GridLayout(2, 1));
  leftPanel.add(receiptPanel);
  leftPanel.add(panelTables());
  leftPulsRightPanel.setLayout(new GridLayout(1, 2));
  leftPulsRightPanel.add(leftPanel);
  leftPulsRightPanel.add(panelMenu());
  totalPanel=leftPulsRightPanel;
 }
 private JTextField textTableNum(){  //textTableNum()�Լ��� ����ؼ� textTableNum�ؽ�Ʈ �ʵ忡 ���̺� ��ȣ�� ���
  textTableNum.setText((tableNum+1)+"�� ���̺�");//textTableNum�ؽ�Ʈ �ʵ忡  ���̺� ��ȣ�� ���
  return textTableNum;
 }
 private JTextArea textReceiptArea(){
  textReceiptArea.setText("");//�ؽ�Ʈ ����� �ʱ�ȭ
  for(int j=0;j<8;j++){
   textReceiptArea.setText(textReceiptArea.getText()+data[tableNum][j][0]+"\t|  "+data[tableNum][j][1]+"\t|  "+data[tableNum][j][2]+"\t|\n");
  }//�� ���̺� ���� �ֹ��� �޴����   �޴��鿡 ����  ������  �ݾ��� ���
  textReceiptArea.setText(textReceiptArea.getText()+"�հ�\t\t|  "+finalMoney.getText()+"\t|");//textReceiptArea�հԸ� ���
  return textReceiptArea;//textReceiptArea�� ��ȯ �Ѵ�
 }
 private JPanel panelReceiptCalculation(){
  JPanel panel=new JPanel();   //jpanel ����
  panel.setLayout(new FlowLayout(FlowLayout.RIGHT,4,0));//panel  ������  FlowLayout�ƿ����� ����
  panel.add(calculate);//panel�� ��� ��ư�� �߰�
  panel.add(finalMoney);//panel��  �� �հԸ� ��� �ϴ�  finalMoney�ؽ�Ʈ �ʵ带 �߰�
  return panel;
 }
 private JPanel panelMenu(){
  JPanel[] menuP=new JPanel[menuB.length];
  JPanel[] southMenuP=new JPanel[menuB.length];
  JPanel totalMenuP=new JPanel();    
  totalMenuP.setLayout(new GridLayout(4, 2));  
  for(int i=0;i<menuB.length;i++){
   menuP[i]=new JPanel();
   southMenuP[i]=new JPanel();
   menuP[i].setLayout(new BorderLayout());
   southMenuP[i].setLayout(new FlowLayout(FlowLayout.CENTER,2, 0));
   menuP[i].add(menuB[i],BorderLayout.CENTER);   
   southMenuP[i].add(plusB[i]);
   southMenuP[i].add(counts[i][0]);
   southMenuP[i].add(minusB[i]);
   southMenuP[i].add(counts[i][1]);
   menuP[i].add(southMenuP[i],BorderLayout.SOUTH);
   totalMenuP.add(menuP[i]);
  }
  return totalMenuP;
 }
 private JPanel panelTables(){//���̺� ��ư�� ���� �ϱ� ����  �г��� �Լ��� ����
  JPanel tebleP=new JPanel();//jpanel�� table�̶�� ��ü�� ����
  tebleP.setLayout(new GridLayout(3, 3));//tebleP��� ���� GridLayout  ��������3�� 3���� ���� 
  for(int i=0;i<tableB.length;i++){  //tableb�� ũ�⸸ŭ �����鼭 table��ư�� �߰�
   tebleP.add(tableB[i]);   
  }
  return tebleP;//tebleP�� ��ȯ
 } 
 @Override
 public void actionPerformed(ActionEvent e) {
  JButton jb=(JButton)e.getSource();  //jb���  ��ü�� �߻���Ų  ��ư ��ü�� ����
  for(int i=0;i<tableB.length;i++){//���̺� ����ū for���� ������
   if(jb==tableB[i]){// �߻��� ��ư�� ��ü�� ���̺� ��ư ��ü�� ���ٸ�  �Ʒ� ������ ����
    int sum=0;    //���հԸ� ���ϱ� ���ؼ� sum���̶� ������ int ������ �������� 0�̶�� �ʱⰪ  ����
    tableNum=i;  //�ش� ���̺��� �˱����ؼ�  ������ tableNum�̶�� ������   �ش� ���̺� ��  ���� ���� 
    textTableNum(); //textTableNum �Լ��� ����   ��� ���̺����� ��Ÿ���� ���ؼ�
    for(int j=0;j<menuB.length;j++){//�޴� ��ư ��ū �ݺ� ���� �Ѵ�
     sum+=Integer.parseInt(data[tableNum][j][2]);//sum�̶�� ������  �� �޴��鿡 ���� �հ踦 �����ش�
    }
    finalMoney.setText("0");//�� �հԸ� ��� �ϴ� text�ʵ忡  �ݾ׿� 0 �̶�� ���� ���� ���
    finalMoney.setText(sum+"");////�� �հԸ� ��� �ϴ� text�ʵ忡   sum�̶�� ���� ���ڿ��� ��ȯ�� sum���� ���
    textReceiptArea();    //textReceiptArea�޼��� ����
   }
  }
  for(int i=0;i<menuB.length;i++){
   if(jb==menuB[i]){//�ܼ� �޴� ��ư�� ��������  �ش� �Ǵ� �޴� �� ������ 1�� ����
    data[tableNum][i][1]=(Integer.parseInt(data[tableNum][i][1])+1)+"";//�޴��� ������ 1���� ��Ű�� ���ڿ��� ��ȯ
    data[tableNum][i][2]=(Integer.parseInt(data[tableNum][i][1])*MENUMONEY[i])+"";//�ش� �޴��ǰ����� ���� �ݾ��� ������ ���ڿ��� ��ȯ
    finalMoney.setText((Integer.parseInt(finalMoney.getText())+1*MENUMONEY[i])+""); // �޴��� ��Ż �ݾ��� ���ڿ��� ��ȯ�� 
    //
    textReceiptArea();//extReceiptArea�޼��� ����
   }
  }
  for(int i=0;i<menuB.length;i++){
   if(jb==plusB[i]){//�޴����� ������ �߰� ������ ����ϱ� ���� �Լ�  �ؽ�Ʈ ���� 2�ϰ� +��ư�� ������   �ش� �޴��� ������ �߰� �ǰ�    ���� ��� �ݾ׿���  �߰��� �޴��� �ݾ� ��ŭ ���Ѵ�
    data[tableNum][i][1]=(Integer.parseInt(data[tableNum][i][1])+Integer.parseInt(counts[i][0].getText()))+"";//�ش� �ؽ�Ʈ �ʵ忡 ���� ����ŭ �ش� �޴��� ������ �߰��ϰ� ���ڿ� �Ѵ�
    data[tableNum][i][2]=(Integer.parseInt(data[tableNum][i][1])*MENUMONEY[i])+"";   //�� �޴��� ���� �ݾ��� ���ϰ� ���ڿ� �Ѵ�
    finalMoney.setText((Integer.parseInt(finalMoney.getText())+Integer.parseInt(counts[i][0].getText())*MENUMONEY[i])+"");//�� �հ����� ���ϴ� finalMoney�ؽ�Ʈ �ʵ忡 ���� �����  �ݾװ� �߰��� �ֹ��� �޴� ���� ��ŭ ���Ѱ� ����Ѵ�      
    textReceiptArea();//extReceiptArea�޼��� ����
    counts[i][0].setText(""+0);
   }
  }
  for(int i=0;i<menuB.length;i++){   
   if(jb==minusB[i]){//�޴����� ������ ���� �� ����ϱ� ���� �Լ�  �ؽ�Ʈ ���� 2�ϰ� -��ư�� ������   �ش� �޴��� ������ �ؽ�Ʈ �ʵ忡 �Էµ� ����ŭ  ������    ���� ��� �ݾ׿���  �߰��� �޴��� �ݾ� ����
    data[tableNum][i][1]=(Integer.parseInt(data[tableNum][i][1])-Integer.parseInt(counts[i][1].getText()))+""; //���� �޴��� �������� �ؽ�Ʈ �ʵ忡 �Է� �� ��ŭ ���� ���ڿ�
    data[tableNum][i][2]=(Integer.parseInt(data[tableNum][i][1])*MENUMONEY[i])+""; //�� �޴��� ���� �ݾ��� ���ϰ� ���ڿ� �Ѵ�  
    finalMoney.setText((Integer.parseInt(finalMoney.getText())-Integer.parseInt(counts[i][1].getText())*MENUMONEY[i])+"");;//�� �հ����� ���ϴ� finalMoney�ؽ�Ʈ �ʵ忡 ���� �����  �ݾװ� �߰��� �ֹ��� �޴� ���� ��ŭ ���� ����Ѵ�        
    textReceiptArea();//extReceiptArea�޼��� ����
    counts[i][1].setText(""+0);
   }
  }
  if(jb==calculate){ //��� ��ư�� ��������       ���ݾ��� ��µ� �ؽ�Ʈ �ʵ� ���� 0���� �ʱ�ȭ �ȴ�  
   for(int i=0;i<menuB.length;i++){
    dat.getMenuCount()[i]+=Integer.parseInt(data[tableNum][i][1]);//��   �޴��鿡 ���� ������  ���Ѵ�
    dat.getMenuMoney()[i]+=Integer.parseInt(data[tableNum][i][2]); //�� �޴��鿡 ���� ��Ż �ݾ� �� ���Ѵ�   
    data[tableNum][i][1]="0";//0���� �ʱ�ȭ
    data[tableNum][i][2]="0";//0���� �ʱ�ȭ    
   }
   dat.setSumMoney(dat.getSumMoney() + Integer.parseInt(finalMoney.getText()));
   try{
    new FileManager().save(saveDat());
   }
   catch(IOException e4){
    counts[1][1].setText("4");
   }
   finalMoney.setText("0");
   textReceiptArea();
  }  
 } 
 public JPanel getTotalPanel(){
  return totalPanel;
 }
 public Data getDat() {
  return dat;
 }
 public void setDat(Data dat) {
  this.dat = dat;
 }
 public Data saveDat(){
  return this.dat;
 }
}