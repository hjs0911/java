package kr.hkit.android_activity.interfaces;

import java.util.ArrayList;

public interface InterCalculator {
	/*public int add(int a, int b);
	public int sub(int a, int b) throws UnImplementedException;
	public int mul(int a, int b) throws UnImplementedException;
	public int div(int a, int b) throws UnImplementedException;*/
	
	int calculate(int a, int b);
	
	public void claerHistory();
	
	public ArrayList<CalcData> getHistory();
}
