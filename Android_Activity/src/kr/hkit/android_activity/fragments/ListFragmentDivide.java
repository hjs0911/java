package kr.hkit.android_activity.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class ListFragmentDivide extends Activity implements WordListFragment.OnWordChangeListener{
	TextView wordDesc;
	String[] DESC;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wordlist);
		wordDesc = (TextView) findViewById(R.id.worddesc);
		DESC = getResources().getStringArray(R.array.desc);
	}
	
	@Override
	public void onWordChanged(int index) {
		wordDesc.setText(DESC[index]);
	}

}
