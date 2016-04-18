package kr.hkit.android_activity.fragments;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import kr.hkit.android_activity.R;

public class FragmentArgument extends Activity {
	EditText startNum;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragmentarg);
		
		startNum = (EditText) findViewById(R.id.startNum);
		
		findViewById(R.id.arg_Btnadd).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Bundle args = new Bundle();
				args.putInt("start", Integer.parseInt(startNum.getText().toString()));
				CounterFragment cf = new CounterFragment();
				cf.setArguments(args);
				
				getFragmentManager()
				.beginTransaction()
				.addToBackStack(null)
				.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
				.add(R.id.arg_frame, cf, "counter")
				.commit();
				
			}
		});
	}

}
