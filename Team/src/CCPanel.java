import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
public class CCPanel extends JPanel implements ActionListener{
 private static final long serialVersionUID = 1L; 
 private String[] title=new String[3];
 private String[][][] data=new String[9][8][3];//각 테이블의 메누에 대학  수량과 금액을  저장 하기 위해서 3차원 열 만듬
 private JButton[] tableB=new JButton[9];  //테이블 버튼을 사용 하기 위해서  버튼 9개를 저장할 버튼 배열을 만든다 
 private JButton[] menuB=new JButton[8];
 private JTextField[][] counts=new JTextField[8][2];//+-버튼옆에 텍스트 필드를 만들기 위해서  8행 2열을 가진 2차원 택스트 필드를 생성  
 private JButton[] plusB=new JButton[8];
 private JButton[] minusB=new JButton[8];//메뉴 버튼 8개를 생성 하기 위해서 8개 크기의   jbutton배열 생성
 private JTextField finalMoney=new JTextField("0",10);//크기가 10인 텍스트 필드를 생성
 private JButton calculate=new JButton("계산");//게산을하기 위해 j버튼을 생성
 private JPanel totalPanel=new JPanel();
 private int tableNum=0;// 어느 테이블인지를 알기 위해서 정수형 변수를 선언
 private JPanel leftPanel=new JPanel();//각 테이블의 버튼과     메누들의 수량 및 합계 와 홥게 금액등을 추가 아기 위해서 jpanel 생성
 private JPanel leftPulsRightPanel=new JPanel();
 private final String[] MENUNAME={"돼지고기","닭고기","소고기","치킨","삼겹살","등심","안심","으악"};
 private final int[] MENUMONEY={4000,3000,5000,6000,4000,3000,2000,7000};  //메뉴딀의 가격 을 저장할 정수형 MENUMONEY배열 선언및 생성 
 private JPanel receiptPanel=new JPanel(); // 총 합계를 출력하는 텍스트 필드와  메뉴마다 주문된 것들을 볼수 있는 텍스트 에어리어를 추가 하기 위해서   j panel 생성
 private JTextField textTableNum=new JTextField();//준문할 테이블을 출력 하기 위해서 text필드를 생성
 private JTextArea textReceiptArea=new JTextArea(); //각 메뉴마다  주문된 갯 수와    메뉴의 합계 금액을 알기 위해서 textarea필드를 생성
 private Data dat; //date객체를 생성
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
  title[0]="주문";
  title[1]="수량";
  title[2]="금액";
  for(int i=0;i<data.length;i++){//데이터의 트기 만금 반복 하면서 for문 실행
   for(int j=0;j<data[i].length;j++){
    data[i][j][0]=dat.getMenuName()[j];    //테이블 마다       메뉴들을  불러내서 저장
    data[i][j][1]="0";  // 갯수 초가화
    data[i][j][2]="0";  // 금액 초기화
   }
  }
  for(int i=0;i<counts.length;i++){
   for(int j=0;j<counts[1].length;j++){
    counts[i][j]=new JTextField("0",4);  // 메뉴 버튼의 +-버튼 옆의 텍스트 필드를 생성 하기 위해서 2차원 배열로 선언
    
   }
  }
  for(int i=0;i<menuB.length;i++){
   menuB[i]=new JButton(dat.getMenuName()[i]);//메뉴버튼을 생성 하고 액션 효과를 주기 위해서 
   menuB[i].addActionListener(this);// 버튼 눌럴을때 효과를 주기 위해 사용
  }
  for(int i=0;i<tableB.length;i++){//테이블을  버튼을 생성 하기 위해서 
   tableB[i]=new JButton((i+1)+"번 테이블");  //  각 버튼 배열의 마다  1,2,3,4,5,6,7,8,9라는 이름을 가진 버튼들을 저장한다
   tableB[i].addActionListener(this);// 버튼 마다 효과를 주기 위해서 사용
  }
  for(int i=0;i<plusB.length;i++){  //낱개 추가 주문을 하기 위해서 plusB버튼 배열을 만든후   배열마다  버튼을 생성
   plusB[i]=new JButton("+"); //plubs라는 버튼의 배열에 +라는 이름을 가진 버튼 8개를 저장  낱개 만큼추가 하기 위해서
   plusB[i].addActionListener(this);// 버튼 마다 효과를 주기 위해서 사용
  }
  for(int i=0;i<plusB.length;i++){
   minusB[i]=new JButton("-");   //추가 주문한거에서 낱개를 빼기 위해서  minusB버튼 배열로 만든후 배열마다 -이름을  가진 버튼 저장
   minusB[i].addActionListener(this);//버튼 효과를 사용하기 위해서 사용
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
 private JTextField textTableNum(){  //textTableNum()함수를 사용해서 textTableNum텍스트 필드에 테이블 번호를 출력
  textTableNum.setText((tableNum+1)+"번 테이블");//textTableNum텍스트 필드에  테이블 번호를 출력
  return textTableNum;
 }
 private JTextArea textReceiptArea(){
  textReceiptArea.setText("");//텍스트 에어리어 초기화
  for(int j=0;j<8;j++){
   textReceiptArea.setText(textReceiptArea.getText()+data[tableNum][j][0]+"\t|  "+data[tableNum][j][1]+"\t|  "+data[tableNum][j][2]+"\t|\n");
  }//각 테이블 마다 주문한 메뉴들과   메뉴들에 대한  객수와  금액을 출력
  textReceiptArea.setText(textReceiptArea.getText()+"합계\t\t|  "+finalMoney.getText()+"\t|");//textReceiptArea합게를 출력
  return textReceiptArea;//textReceiptArea을 반환 한다
 }
 private JPanel panelReceiptCalculation(){
  JPanel panel=new JPanel();   //jpanel 생성
  panel.setLayout(new FlowLayout(FlowLayout.RIGHT,4,0));//panel  형식을  FlowLayout아웃으로 선언
  panel.add(calculate);//panel에 계산 버튼을 추가
  panel.add(finalMoney);//panel에  총 합게를 출력 하는  finalMoney텍스트 필드를 추가
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
 private JPanel panelTables(){//테이블 버튼을 생성 하기 위한  패널을 함수로 만듬
  JPanel tebleP=new JPanel();//jpanel을 table이라는 객체로 생성
  tebleP.setLayout(new GridLayout(3, 3));//tebleP라는 놈을 GridLayout  형식으로3행 3열을 생성 
  for(int i=0;i<tableB.length;i++){  //tableb의 크기만큼 돌리면서 table버튼을 추가
   tebleP.add(tableB[i]);   
  }
  return tebleP;//tebleP을 반환
 } 
 @Override
 public void actionPerformed(ActionEvent e) {
  JButton jb=(JButton)e.getSource();  //jb라는  객체에 발생시킨  버튼 객체를 저장
  for(int i=0;i<tableB.length;i++){//테이블 수만큰 for문을 돌린다
   if(jb==tableB[i]){// 발생된 버튼의 객체가 테이블 버튼 객체와 맏다면  아래 문장을 실행
    int sum=0;    //총합게를 구하기 위해서 sum값이라난 정수형 int 벼수를 선언한후 0이라는 초기값  설정
    tableNum=i;  //해당 테이블의 알기위해서  정수형 tableNum이라는 변수에   해당 테이블 의  값을 저장 
    textTableNum(); //textTableNum 함수를 실행   몇번 테이블인지 나타내기 위해서
    for(int j=0;j<menuB.length;j++){//메뉴 버튼 만큰 반복 실행 한다
     sum+=Integer.parseInt(data[tableNum][j][2]);//sum이라는 변수에  각 메뉴들에 대한 합계를 더해준다
    }
    finalMoney.setText("0");//총 합게를 출력 하는 text필드에  금액에 0 이라는 문자 열을 출력
    finalMoney.setText(sum+"");////총 합게를 출력 하는 text필드에   sum이라는 값을 문자열로 변환후 sum값을 출력
    textReceiptArea();    //textReceiptArea메서드 실행
   }
  }
  for(int i=0;i<menuB.length;i++){
   if(jb==menuB[i]){//단순 메뉴 버튼을 눌렀을때  해당 되는 메뉴 의 수량이 1씩 증가
    data[tableNum][i][1]=(Integer.parseInt(data[tableNum][i][1])+1)+"";//메뉴의 갯수를 1증가 시키고 문자열로 전환
    data[tableNum][i][2]=(Integer.parseInt(data[tableNum][i][1])*MENUMONEY[i])+"";//해당 메뉴의갯수에 대한 금액을 구한후 문자열로 전환
    finalMoney.setText((Integer.parseInt(finalMoney.getText())+1*MENUMONEY[i])+""); // 메뉴의 토탈 금액을 문자열로 전환한 
    //
    textReceiptArea();//extReceiptArea메서드 실행
   }
  }
  for(int i=0;i<menuB.length;i++){
   if(jb==plusB[i]){//메뉴에서 낱개로 추가 했을때 사용하기 위함 함수  텍스트 값에 2하고 +버튼을 누르면   해당 메뉴의 개수가 추가 되고    현재 계산 금액에서  추가된 메누의 금액 만큼 더한다
    data[tableNum][i][1]=(Integer.parseInt(data[tableNum][i][1])+Integer.parseInt(counts[i][0].getText()))+"";//해당 텍스트 필드에 적은 수만큼 해당 메뉴의 갯수를 추가하고 문자열 한다
    data[tableNum][i][2]=(Integer.parseInt(data[tableNum][i][1])*MENUMONEY[i])+"";   //각 메뉴에 대한 금액을 구하고 문자열 한다
    finalMoney.setText((Integer.parseInt(finalMoney.getText())+Integer.parseInt(counts[i][0].getText())*MENUMONEY[i])+"");//총 합개를출 력하는 finalMoney텍스트 필드에 현재 저장된  금액과 추가된 주문된 메뉴 수량 만큼 더한고 출력한다      
    textReceiptArea();//extReceiptArea메서드 실행
    counts[i][0].setText(""+0);
   }
  }
  for(int i=0;i<menuB.length;i++){   
   if(jb==minusB[i]){//메뉴에서 낱개로 뺐을 때 사용하기 위함 함수  텍스트 값에 2하고 -버튼을 누르면   해당 메눅의 개수가 텍스트 필드에 입력된 값만큼  빼지고    현재 계산 금액에서  추가된 메누의 금액 뺀다
    data[tableNum][i][1]=(Integer.parseInt(data[tableNum][i][1])-Integer.parseInt(counts[i][1].getText()))+""; //현재 메뉴의 갯수에서 텍스트 필드에 입력 한 만큼 빼고 문자열
    data[tableNum][i][2]=(Integer.parseInt(data[tableNum][i][1])*MENUMONEY[i])+""; //각 메뉴에 대한 금액을 구하고 문자열 한다  
    finalMoney.setText((Integer.parseInt(finalMoney.getText())-Integer.parseInt(counts[i][1].getText())*MENUMONEY[i])+"");;//총 합개를출 력하는 finalMoney텍스트 필드에 현재 저장된  금액과 추가된 주문된 메뉴 수량 만큼 빼고 출력한다        
    textReceiptArea();//extReceiptArea메서드 실행
    counts[i][1].setText(""+0);
   }
  }
  if(jb==calculate){ //계산 버튼을 눌렀을때       계산금액이 출력될 텍스트 필드 값이 0으로 초기화 된다  
   for(int i=0;i<menuB.length;i++){
    dat.getMenuCount()[i]+=Integer.parseInt(data[tableNum][i][1]);//각   메뉴들에 대한 갯수를  더한다
    dat.getMenuMoney()[i]+=Integer.parseInt(data[tableNum][i][2]); //각 메뉴들에 대한 토탈 금액 을 더한다   
    data[tableNum][i][1]="0";//0으로 초기화
    data[tableNum][i][2]="0";//0으로 초기화    
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