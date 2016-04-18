package kr.hkit.android_activity.interfaces;

import java.util.ArrayList;

import android.content.Context;
import android.widget.Toast;

public class FriendCalculator implements InterCalculator {
	Context context;

	public FriendCalculator(Context context) {
		this.context = context;
	}

	@Override
	public int calculate(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
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
		Toast.makeText(context, "더하기를 했습니다ㅗㅗ", Toast.LENGTH_SHORT).show();
		return a+b;
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
