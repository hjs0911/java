package kr.hkit.android_advance_widget.switchex;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;
import kr.hkit.android_advance_widget.R;

public class SwitchEx extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.switchex);
		
		Switch sw = (Switch) findViewById(R.id.switch1);
		sw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				Toast.makeText(getApplicationContext(), "체크상태 - " + isChecked, Toast.LENGTH_SHORT).show();
				
			}
		});
	}
}
