package kr.hkit.android_advance_widget.progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import kr.hkit.android_advance_widget.R;
import kr.hkit.android_advance_widget.R.id;
import kr.hkit.android_advance_widget.R.layout;

public class ProgressBarEx extends Activity {
	ProgressBar mProgBar, mProgCircle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progressbarex);
		mProgBar = (ProgressBar) findViewById(R.id.proB_01);
		mProgCircle = (ProgressBar) findViewById(R.id.proBCircle);
	}
	
	public void mOnClick(View v){
		switch(v.getId()){
		case R.id.btn_DecF:
			mProgBar.incrementProgressBy(-2);
			break;
		case R.id.btn_IncF:
			mProgBar.incrementProgressBy(2);
			break;
		case R.id.btn_DecS:
			mProgBar.incrementSecondaryProgressBy(-2);
			break;
		case R.id.btn_IncS:
			mProgBar.incrementSecondaryProgressBy(2);
			break;
		case R.id.btn_Start:
			mProgCircle.setVisibility(View.VISIBLE);
			break;
		case R.id.btn_Stop:
			mProgCircle.setVisibility(View.INVISIBLE);
			break;
		}
	}
}
