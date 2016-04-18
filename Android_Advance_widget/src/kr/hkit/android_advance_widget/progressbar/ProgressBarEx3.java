package kr.hkit.android_advance_widget.progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import kr.hkit.android_advance_widget.R;

public class ProgressBarEx3 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.progressbarex3);
	}
	
	public void seekClick(View v){
		switch(v.getId()){
		case R.id.btn_seekStart:
			setProgressBarIndeterminateVisibility(true);
			break;
		case R.id.btn_seekStop:
			setProgressBarIndeterminateVisibility(false);
			break;
		}
	}
}
