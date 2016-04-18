package kr.hkit.android_activity.fragments;

import android.app.Activity;
import android.os.Bundle;
import kr.hkit.android_activity.R;

public class ReuseFragment extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reusefragment);
	}
}
