package kr.hkit.android_activity.schedule;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;
import kr.hkit.android_activity.R;

public class PostDelayedEx extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload);
	}
	
	Handler mHandler = new Handler();
	
	public void mOnClick(View v){
		new AlertDialog.Builder(this)
		.setTitle("질문")
		.setMessage("업로드 하시겠습니까?")
		.setPositiveButton("예", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				mHandler.postDelayed(new Runnable() {
					
					@Override
					public void run() {
						doUpload();
					}
				}, 10);
			}
		}).setNegativeButton("아니오", null).show();
	}

	protected void doUpload() {
		for(int i=0; i<20; i++){
			try{Thread.sleep(100);}catch(InterruptedException e){}
		}
		Toast.makeText(this, "업로드를 완료했습니다", Toast.LENGTH_SHORT).show();
	}
}
