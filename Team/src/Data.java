import java.io.Serializable;

public class Data implements Serializable{
	private static final long serialVersionUID = 1L;
	private int sumMoney;
	private String menuName[] = new String[8];
	private int menuMoney[] = new int[8];
	private int menuCount[] = new int[8];
	public Data() {
		this.setSumMoney(0);			 
		for(int i=0;i<getMenuCount().length;i++){
			this.getMenuName()[i]="";
			this.getMenuCount()[i]=0;
			this.getMenuMoney()[i]=0;
		}
	}
	public void setMenuName(String[] menuName) {
		this.menuName = menuName;
	}
	public String[] getMenuName() {
		return menuName;
	}
	public int[] getMenuCount() {
		return menuCount;
	}

	public void setMenuCount(int menuCount[]) {
		this.menuCount = menuCount;
	}
	public int[] getMenuMoney() {
		return menuMoney;
	}

	public void setMenuMoney(int menuMoney[]) {
		this.menuMoney = menuMoney;
	}

	public int getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(int sumMoney) {
		this.sumMoney = sumMoney;
	}
}
