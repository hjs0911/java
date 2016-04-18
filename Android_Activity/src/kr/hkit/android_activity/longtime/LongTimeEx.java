package kr.hkit.android_activity.longtime;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class LongTimeEx extends Activity {
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
		Update();
	}

	private void Update() {
		for (int i=0; i<100; i++){
			mValue++;
			mText.setText(Integer.toString(mValue));
			
			try{Thread.sleep(50);}catch(InterruptedException e){;}
		}
	}
}
