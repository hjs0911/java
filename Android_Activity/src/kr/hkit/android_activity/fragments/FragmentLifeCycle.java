package kr.hkit.android_activity.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class FragmentLifeCycle extends Activity {
	final String TAG = "Fragment Life Cycle";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d(TAG, "onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragmentlifecycle);
	}

	@Override
	protected void onStart() {
		Log.d(TAG, "onStart()");
		super.onStart();
	}

	@Override
	protected void onResume() {
		Log.d(TAG, "onResume()");
		super.onResume();
	}

	@Override
	protected void onPause() {
		Log.d(TAG, "onPause()");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.d(TAG, "onStop()");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.d(TAG, "onDestroy()");
		super.onDestroy();
	}

	public static class CounterFragment extends Fragment {
		final static String TAG = "Fragment Life Cycle";
		
		@Override
		public void onAttach(Activity activity) {
			Log.d(TAG, "		Fragment - onAttach()");
			super.onAttach(activity);
		}

		@Override
		public void onCreate(Bundle savedInstanceState) {
			Log.d(TAG, "		Fragment - onCreate()");
			super.onCreate(savedInstanceState);
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			Log.d(TAG, "		Fragment - onCreateView()");
			View root = inflater.inflate(R.layout.counterfragment, container, false);
			
			final TextView tv = (TextView) root.findViewById(R.id.textCounter);
			
			if(savedInstanceState != null){
				tv.setText(Integer.toString(savedInstanceState.getInt("counter")));
			}
			
			root.findViewById(R.id.btnIncrease).setOnClickListener(new View.OnClickListener() {
		
				@Override
				public void onClick(View v) {
					int count = Integer.valueOf(tv.getText().toString());
					tv.setText(Integer.toString(count + 1));
				}
			});
			
			return root;
		}
		
		@Override
		public void onSaveInstanceState(Bundle outState) {
			super.onSaveInstanceState(outState);
			TextView tv = (TextView) getView().findViewById(R.id.textCounter);
			int a = Integer.parseInt(tv.getText().toString());
			outState.putInt("counter", a);
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			Log.d(TAG, "		Fragment - onActivityCreated()");
			super.onActivityCreated(savedInstanceState);
		}

		@Override
		public void onStart() {
			Log.d(TAG, "		Fragment - onStart()");
			super.onStart();
		}

		@Override
		public void onResume() {
			Log.d(TAG, "		Fragment - onResume()");
			super.onResume();
		}

		@Override
		public void onPause() {
			Log.d(TAG, "		Fragment - onPause()");
			super.onPause();
		}

		@Override
		public void onStop() {
			Log.d(TAG, "		Fragment - onStop()");
			super.onStop();
		}

		@Override
		public void onDestroyView() {
			Log.d(TAG, "		Fragment - onDestroyView()");
			super.onDestroyView();
		}

		@Override
		public void onDestroy() {
			Log.d(TAG, "		Fragment - onDestroy()");
			super.onDestroy();
		}

		@Override
		public void onDetach() {
			Log.d(TAG, "		Fragment - onDetach()");
			super.onDetach();
		}
	}

}
