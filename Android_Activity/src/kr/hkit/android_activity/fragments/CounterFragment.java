package kr.hkit.android_activity.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class CounterFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.counterfragment, container, false);
		final TextView textCnt = (TextView) root.findViewById(R.id.textCounter);
		
		Bundle args = getArguments();
		int start = args.getInt("start");
		
		textCnt.setText(Integer.toString(start));
		
		root.findViewById(R.id.btnIncrease).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int count = Integer.parseInt(textCnt.getText().toString());
				textCnt.setText(Integer.toString(count+1));
			}
		});
		return root;
	}
}
