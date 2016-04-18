package kr.hkit.android_broadcast;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class LoginEx extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView tv = new TextView(this);
		tv.setText("로그인 화면");
		tv.setTextSize(40);
		
		setContentView(tv);
	}
}
