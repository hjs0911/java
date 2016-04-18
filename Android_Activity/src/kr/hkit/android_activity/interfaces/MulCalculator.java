package kr.hkit.android_activity.interfaces;

import java.util.ArrayList;

public class MulCalculator implements InterCalculator {

	@Override
	public int calculate(int a, int b) {
		return a*b;
	}

	@Override
	public void claerHistory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<CalcData> getHistory() {
		// TODO Auto-generated method stub
		return null;
	}

}
