package kr.hkit.android_activity.interfaces;

import java.util.ArrayList;

import kr.hkit.android_activity.R;

public class FactoryCal {

/*	public static InterCalculator getInstance(CalType operType) {
		InterCalculator cal = null;
		switch(operType){
		case ADD:
			cal = new MyCalculator();
			break;
		case SUB:
			cal = new SubCalculator();
			break;
		case MUL:
			cal = new MulCalculator();
			break;
		case DIV:
			cal = new DivCalculator();
			break;
		}
		return cal;
	}*/
	
	public static InterCalculator getInstance(int operType) {
		InterCalculator cal = null;
		
		switch(operType){
		case R.id.btnAdd:
			cal = new AddCalculator();
			break;
		case R.id.btnSub:
			cal = new SubCalculator();
			break;
		case R.id.btnMul:
			cal = new MulCalculator();
			break;
		case R.id.btnDiv:
			cal = new DivCalculator();
			break;
		case R.id.btnPow:
			cal = new PowerCalculator();
			break;
		}
		return cal;
	}
}
