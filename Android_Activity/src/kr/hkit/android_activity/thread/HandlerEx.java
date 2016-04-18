package kr.hkit.android_activity.thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class HandlerEx extends Activity {
	int mMainValue, mBackValue;
	TextView tvMain, tvBack;

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if (msg.what == 0) {
				tvBack.setText("BackValue : " + mBackValue);
			}
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.threadex);
		tvMain = (TextView) findViewById(R.id.MainValue);
		tvBack = (TextView) findViewById(R.id.backValue);

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					mBackValue++;
					handler.sendEmptyMessage(0);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		thread.setDaemon(true);
		thread.start();
	}

	public void mOnClick(View v) {
		mMainValue++;
		tvMain.setText("MainValue : " + mMainValue);
	}
}
