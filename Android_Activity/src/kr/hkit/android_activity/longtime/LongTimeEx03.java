package kr.hkit.android_activity.longtime;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class LongTimeEx03 extends Activity {
	int mValue;
	TextView mText;
	ProgressDialog mProgress;
	boolean mQuit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.longtimeex);
		mText = (TextView) findViewById(R.id.tvTime);
	}
	
	public void Click(View v){
		if(mValue == 100){
			mValue = 0;
		}
		
		mProgress = new ProgressDialog(this);
		mProgress.setTitle("Updating");
		mProgress.setMessage("Wait...");
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
		mHandler.sendEmptyMessage(0);
	}
	
	Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			mValue++;
			mText.setText(Integer.toString(mValue));
			try{Thread.sleep(50);}catch(InterruptedException e){;}
			if(mValue < 100){
				mProgress.setProgress(mValue);
				mHandler.sendEmptyMessage(0);
			}else{
				mProgress.dismiss();
			}
		}
	};
}
