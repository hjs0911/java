package kr.hkit.android_advance_widget.progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import kr.hkit.android_advance_widget.R;

public class ProgressBarEx2 extends Activity {
	int mProg;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.progressbarex2);
		
		mProg = 5000;
		setProgress(mProg);
		setProgressBarVisibility(true);
	}
	
	public void Click(View v){
		switch(v.getId()){
		case R.id.btn_protitle_01:
			if(mProg >= 200) mProg -= 200;
			setProgress(mProg);
			break;
		case R.id.btn_protitle_02:
			if(mProg <= 9800) mProg += 200;
			setProgress(mProg);
			break;
		}
	}
}
