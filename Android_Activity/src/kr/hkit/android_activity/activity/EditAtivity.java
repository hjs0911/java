package kr.hkit.android_activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import kr.hkit.android_activity.R;

public class EditAtivity extends Activity {
	private EditText et;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.editactivity);
		
		Intent intent = getIntent();
		et = (EditText) findViewById(R.id.strEdit);
		et.setText(intent.getStringExtra("TextIn"));
	}
	
	public void mOnClick(View v){
		switch(v.getId()){
		case R.id.btnOK:
			Intent data = new Intent();
			data.putExtra("TextOut", et.getText().toString());
			setResult(RESULT_OK, data);
			break;
		case R.id.btnCancel:
			setResult(RESULT_CANCELED);
			break;
		}
		finish();
	}
}
