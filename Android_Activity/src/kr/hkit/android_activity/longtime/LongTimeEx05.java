package kr.hkit.android_activity.longtime;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class LongTimeEx05 extends Activity {
	int mValue;
	TextView tv;
	ProgressDialog mProgress;
	boolean mQuit;
	UpdateThread mThread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.longtimeex);
		tv = (TextView) findViewById(R.id.tvTime);

	}

	Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			mValue++;
			tv.setText(mValue + "");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
			if (mValue < 100 && mQuit == false) {
				mProgress.setProgress(mValue);
			} else {
				mQuit = true;
				mProgress.dismiss();
			}
		}

	};

	public void Click(View v) {
		if (mValue > 100)
			mValue = 0;
		mProgress = new ProgressDialog(this);
		mProgress.setTitle("Updating");
		mProgress.setMessage("Wait ...");
		mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mProgress.setCancelable(false);
		mProgress.setOnCancelListener(new OnCancelListener() {

			@Override
			public void onCancel(DialogInterface dialog) {
				mQuit = true;
				mProgress.dismiss();
			}
		});
		mProgress.show();
		mQuit = false;
		mThread = new UpdateThread();
		mThread.start();
		mHandler.sendEmptyMessage(0);
	}

	class UpdateThread extends Thread {
		@Override
		public void run() {
			while (mQuit == false) {
				mValue++;
				Message msg = mHandler.obtainMessage();
				msg.arg1 = mValue;
				mHandler.sendMessage(msg);

				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
				}
			}
		}
	}
}
