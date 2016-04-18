package kr.hkit.android_activity.longtime;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class LongTimeEx02 extends Activity {
	int mValue;
	TextView mText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.longtimeex);
		mText = (TextView) findViewById(R.id.tvTime);
	}
	
	public void Click(View v){
		mValue = 0;
		mHandler.sendEmptyMessage(0);
	}
	
	Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			mValue++;
			mText.setText(Integer.toString(mValue));
			try{Thread.sleep(50);}catch(InterruptedException e){;}
			if(mValue < 100){
				mHandler.sendEmptyMessage(0);
			}
		}
	};
}
