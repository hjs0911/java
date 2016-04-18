package kr.hkit.android_activity.thread;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import kr.hkit.android_activity.R;

class CalcThread extends Thread {
	private Handler mMainHandler;
	private Handler mBackHandler;

	public Handler getmBackHandler() {
		return mBackHandler;
	}

	public CalcThread(Handler Handler) {
		mMainHandler = Handler;
	}

	@Override
	public void run() {
		Looper.prepare();
		mBackHandler = new Handler() {

			public void handleMessage(Message msg) {
				Message retMsg = null;
				switch (msg.what) {
				case 0:
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					}
					;
					retMsg = Message.obtain(mMainHandler, 0, msg.arg1 * msg.arg1, 0);
					break;
				case 1:
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
					}
					;
					retMsg = Message.obtain(mMainHandler, 1, new Double(Math.sqrt(msg.arg1)));
					break;
				}
				mMainHandler.sendMessage(retMsg);
			}
		};
		Looper.loop();
	}
}

public class LooperEx extends Activity {
	int mMainValue;
	TextView tvMain, tvBack;
	EditText etNum;
	CalcThread mThread;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.looperex);
		
		tvMain = (TextView) findViewById(R.id.loopMainValue);
		tvBack = (TextView) findViewById(R.id.loopBackValue);
		etNum = (EditText) findViewById(R.id.number);
		
		mThread = new CalcThread(mHandler);
		mThread.setDaemon(true);
		mThread.start();
	}
	
	Handler mHandler = new Handler(){
		public void handleMessage(Message msg){
			switch(msg.what){
			case 0: tvBack.setText("Square Result : " + msg.arg1); break;
			case 1: tvBack.setText("Root Result : " + ((Double)msg.obj).doubleValue()); break;
			}
		}
	};
	
	public void mOnClick(View v){
		Message msg = null;
		switch(v.getId()){
		case R.id.loopIncrease:
			mMainValue++;
			tvMain.setText("MainValue : " + mMainValue);
			Looper.loop();
			break;
		case R.id.square:
			msg = Message.obtain(mThread.getmBackHandler(), 0, Integer.parseInt(etNum.getText().toString()), 0);
			break;
		case R.id.root:
			msg = Message.obtain(mThread.getmBackHandler(), 1, Integer.parseInt(etNum.getText().toString()), 0);
			break;
		}
		mThread.getmBackHandler().sendMessage(msg);
	}
}
