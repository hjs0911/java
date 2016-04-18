package kr.hkit.android_activity.state;

import android.app.Activity;
import android.os.Bundle;

public class SavaState02 extends Activity {
	private MyView mv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		mv = new MyView(this);
		if(savedInstanceState == null){
			mv.setX(50);
		}else{
			mv.setX(savedInstanceState.getFloat("x"));
		}
		mv.setY(50);
		
		mv.setFocusable(true);
		mv.setFocusableInTouchMode(true);
		setContentView(mv);
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		
		outState.putFloat("x", mv.getX());
	}
}
