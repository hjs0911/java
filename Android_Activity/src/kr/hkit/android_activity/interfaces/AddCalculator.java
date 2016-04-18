package kr.hkit.android_activity.interfaces;

import java.util.ArrayList;

public class AddCalculator implements InterCalculator {

	@Override
	public int calculate(int a, int b) {
		int result = a+b;
		CalculatorAdapter.addHistory(a, b, CalcData.TYPE_ADD, result);
		return result;
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

/*	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) throws UnImplementedException {
		throw new UnImplementedException("빼기기구현안함");
	}

	@Override
	public int mul(int a, int b) throws UnImplementedException {
		throw new UnImplementedException("곱하기구현안함");
	}

	@Override
	public int div(int a, int b) throws UnImplementedException {
		throw new UnImplementedException("나누기구현안함");
	}*/

}
