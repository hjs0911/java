package kr.hkit.android_activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class FontActivity extends Activity {
	TextView text;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fontactivity);
		
		NumberPicker picker = (NumberPicker) findViewById(R.id.numberPicker);
		picker.setMinValue(10);
		picker.setMaxValue(50);
		picker.setWrapSelectorWheel(false);
		
		Intent intent = new Intent();
		text = (TextView) findViewById(R.id.text);
		text.setText(intent.getStringExtra("TextIn"));
	}

	public void Click(View v){
		switch(v.getId()){
		case R.id.btn_Fontsubmit:
			break;
		case R.id.btn_FontCancel:
		}
	}
}
