package kr.hkit.android_activity.thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class Handler_PostEx extends Activity {
	int mMainValue, mBackValue;
	TextView tvMain, tvBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.threadex);

		tvMain = (TextView) findViewById(R.id.MainValue);
		tvBack = (TextView) findViewById(R.id.backValue);

		BackThread thread = new BackThread();
		thread.setDaemon(true);
		thread.start();
	}

	public void mOnClick(View v) {
		mMainValue++;
		tvMain.setText("MainValue : " + mMainValue);
	}

	Handler mHandler = new Handler();

	class BackThread extends Thread {
		@Override
		public void run() {
			while (true) {
				mBackValue++;
				mHandler.post(new Runnable() {

					@Override
					public void run() {
						tvBack.setText("BackValue : " + mBackValue);
					}
				});
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
