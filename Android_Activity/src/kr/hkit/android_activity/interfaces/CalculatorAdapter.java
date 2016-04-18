package kr.hkit.android_activity.interfaces;

import java.util.ArrayList;

public abstract class CalculatorAdapter implements InterCalculator {

	private static ArrayList<CalcData> history = new ArrayList<CalcData>();

	public static void addHistory(int a, int b, int type, int result) {
		CalcData data = new CalcData(a, b, type, result);
		history.add(data);
	}

	public void clearHistory() {
		history.clear();
	}

	public ArrayList<CalcData> getHistory() {
		return history;
	}

	public abstract int add(int a, int b);

	public int sub(int a, int b) throws UnImplementedException {
		throw new UnImplementedException("빼기구현안함");
	}

	public int mul(int a, int b) throws UnImplementedException {
		throw new UnImplementedException("곱하기구현안함");
	}

	public int div(int a, int b) throws UnImplementedException {
		throw new UnImplementedException("나누기구현안함");
	}
}
