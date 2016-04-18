package kr.hkit.android_broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void mOnClick(View v){
		Intent intent = new Intent("FREEWIFI");
		intent.putExtra("BroadCast", "WiFi 가능지역");
		sendBroadcast(intent);
	}
	
	public void Click(View v){
		switch(v.getId()){
		case R.id.btn_BroadCast:
			startActivity(new Intent(this, BroadCastReceiverTest.class));
			break;
		case R.id.btn_sender:
			startActivity(new Intent(this, BroadCastSenderEx.class));
			break;
		}
	}
}
