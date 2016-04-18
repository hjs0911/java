import java.io.IOException;

import javax.swing.JFrame;

public class MainP {
	
	public static void main(String[] args) {
		
		
		boolean loadckeck=false;
		try {
			new FileManager().load();
			loadckeck=true;
			
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		}
		if(!(loadckeck)){
			try{
				
				new FileManager().save(new Data());
			}
			catch(IOException e){
			
			}
		}
		MMFrame mmf;
		try{
			mmf=new MMFrame(new FileManager().load());
			mmf.setVisible(true);
			mmf.setSize(800, 500);
			mmf.setResizable(false);
			mmf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		catch(IOException e){
			System.out.println("jj");
		}
		catch(ClassNotFoundException e){
			System.out.println("1");
			e.printStackTrace();
		}		
	}
}
