package kr.hkit.android_activity.state;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class SavaState03 extends Activity {
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
		
		SharedPreferences pref = getSharedPreferences("SaveState", MODE_PRIVATE);
		mv.setY(pref.getFloat("y", 50));
		
		mv.setFocusable(true);
		mv.setFocusableInTouchMode(true);
		setContentView(mv);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		SharedPreferences pref = getSharedPreferences("SaveState", MODE_PRIVATE);
		SharedPreferences.Editor edit = pref.edit();
		edit.putFloat("y", mv.getY());
		edit.commit();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putFloat("x", mv.getX());
	}
}
