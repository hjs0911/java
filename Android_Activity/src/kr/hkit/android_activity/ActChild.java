package kr.hkit.android_activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class ActChild extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onStart() {
		Log.d(ActParent.TAG, "ActChild - onStart()");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.d(ActParent.TAG, "ActChild - onRestart()");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.d(ActParent.TAG, "ActChild - onResume()");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.d(ActParent.TAG, "ActChild - onPause()");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.d(ActParent.TAG, "ActChild - onStop()");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.d(ActParent.TAG, "ActChild - onDestroy()");
		super.onDestroy();
	}
	
	
}
