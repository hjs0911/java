package kr.hkit.android_activity.interfaces;

public class CalcData {
	int a, b, type, result;
	
	public static final int TYPE_ADD = 1;
	public static final int TYPE_SUB = 2;
	public static final int TYPE_MUL = 3;
	public static final int TYPE_DIV = 4;
	
	

	
	public CalcData(int intA, int intB, int inType, int inResult) {
		a = intA;
		b = intB;
		type = inType;
		result = inResult;
	}

	public CalcData() {}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
