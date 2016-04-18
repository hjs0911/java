package kr.hkit.android_broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BroadCastSenderEx extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broadcastsenderex);
		findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent("kr.co.company.START_WEB");
				intent.putExtra("TTTT", "Google.com으로 이동");
				sendBroadcast(intent);
			}
		});
	}
}
