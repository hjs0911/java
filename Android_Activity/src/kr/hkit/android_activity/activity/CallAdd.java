package kr.hkit.android_activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import kr.hkit.android_activity.R;

public class CallAdd extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calladd);
		findViewById(R.id.btnCallAdd).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("kr.hkit.Add");
				intent.putExtra("left", 3);
				intent.putExtra("right", 5);
				startActivity(intent);
				
			}
		});
	}
}