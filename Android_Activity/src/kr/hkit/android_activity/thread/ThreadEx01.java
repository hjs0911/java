package kr.hkit.android_activity.thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class ThreadEx01 extends Activity {
	int mMainValue, mBackValue;
	TextView tvMain, tvBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.threadex);
		tvMain = (TextView) findViewById(R.id.MainValue);
		tvBack = (TextView) findViewById(R.id.backValue);
		
		/*BackThread thread = new BackThread();
		thread.setDaemon(true);
		thread.start();*/
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					mBackValue++;
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
	
	
	public void mOnClick(View v){
		mMainValue++;
		tvMain.setText("MainValue : " + mMainValue);
		tvBack.setText("BackValue : " + mBackValue);
	}
	
	class BackThread extends Thread{
		@Override
		public void run() {
			while(true){
				mBackValue++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
