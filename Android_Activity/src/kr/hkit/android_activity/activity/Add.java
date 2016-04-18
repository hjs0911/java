package kr.hkit.android_activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class Add extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		
		Intent intent = getIntent();
		int left = intent.getIntExtra("left", 0);
		int right = intent.getIntExtra("right", 0);
		
		TextView result = (TextView) findViewById(R.id.tvResult);
		result.setText(String.format("%d + %d = %d", left, right, left+right));
	}
}
