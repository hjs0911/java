package kr.hkit.android_activity.itents;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.view.View;
import android.widget.Toast;
import kr.hkit.android_activity.R;

public class IntentEx extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.intentex);

		findViewById(R.id.btnVibe).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
				vib.vibrate(10000);
			}
		});
		;

		findViewById(R.id.btnIntent).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				User.loginName = "소녀시대";
				
				Intent myintent = new Intent(getApplicationContext(), SubIntent.class);
				startActivityForResult(myintent, User.REQ_CODE_PHONEBOOK);

			}
		});
		
		
	}

	public void mOnClick(View v) {
		Intent intent = null;
		switch (v.getId()) {
		case R.id.btnWeb:
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
			break;
		case R.id.btnPhone:
			intent = new Intent(Intent.ACTION_CALL, Uri.parse("01010001000"));
			break;
		}
		startActivity(intent);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == User.REQ_CODE_PHONEBOOK){
			if(resultCode == User.RES_CODE_SUCCESS){
				String outName = data.getStringExtra("name");
				Toast.makeText(this, "전달받은 name의 속성값 : " + outName, 
						Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "실패하였습니다.", Toast.LENGTH_SHORT).show();
			}
		}
		
	}
}