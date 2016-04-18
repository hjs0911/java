package kr.hkit.android_activity.state;

import android.app.Activity;
import android.os.Bundle;

public class SaveState01 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyView mv = new MyView(this);
		mv.setX(50);
		mv.setY(50);
		mv.setFocusable(true);
		mv.setFocusableInTouchMode(true);
		
		setContentView(mv);
	}
}
