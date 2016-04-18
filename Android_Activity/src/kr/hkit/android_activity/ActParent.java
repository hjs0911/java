package kr.hkit.android_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ActParent extends Activity {
	public static final String TAG = "Activity Life Cycle";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "ActParent - onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actparent);
	}
	
	public void mOnClick(View v){
		Intent intent = new Intent(this, ActChild.class);
		startActivity(intent);
		
	}

	@Override
	protected void onStart() {
		Log.d(TAG, "ActParent - onStart()");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.d(TAG, "ActParent - onRestart()");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.d(TAG, "ActParent - onResume()");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.d(TAG, "ActParent - onPause()");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "ActParent - onStop()");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "ActParent - onDestroy()");
		super.onDestroy();
	}
	
	
}
