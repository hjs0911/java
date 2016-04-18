import java.io.IOException;
import java.text.SimpleDateFormat;

public class MakeString {
	private Data dat;
	private String str;
	MakeString(String cDate){
		setStr(cDate);
	}
	MakeString(){
		String currentDate = new SimpleDateFormat("yyyyMMdd").format(new java.util.Date());
		setStr(currentDate);
		
	}
	public String getStr() {
		return str;
	}
	private void setStr(String date){
		str="";
		try{			
			dat=new FileManager().load(date);			
		}
		catch(ClassNotFoundException e){
			str="??";
		}
		catch(IOException e){
			str="������ �������� �ʽ��ϴ�.";
		}
		if(str==""){
			str=date+"����\n";
			for(int i=0;i<8;i++){
				str+=dat.getMenuName()[i]+"\t:\t"+dat.getMenuCount()[i]+"�� \t"+dat.getMenuMoney()[i]+"��\n";				
			}
			str+="���� : "+dat.getSumMoney()+"��";			
		}
	}
}
