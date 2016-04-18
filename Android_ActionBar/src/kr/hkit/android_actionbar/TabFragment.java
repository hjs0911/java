package kr.hkit.android_actionbar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabFragment extends Fragment {
	public static TabFragment newInstance(String text){
		TabFragment frag = new TabFragment();
		
		Bundle args = new Bundle();
		args.putString("text", text);
		frag.setArguments(args);
		
		return frag;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		String text = "";
		Bundle args = getArguments();
		if(args != null){
			text = args.getString("text");
		}
		
		View linear = inflater.inflate(R.layout.actiontabfragment, container, false);
		TextView tv = (TextView) linear.findViewById(R.id.tv_content);
		tv.setText(text);
		
		return linear;
		
	}
}
