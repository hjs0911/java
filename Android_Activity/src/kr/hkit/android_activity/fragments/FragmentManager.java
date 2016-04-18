package kr.hkit.android_activity.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import kr.hkit.android_activity.R;
import kr.hkit.android_activity.fragments.FragmentLifeCycle.CounterFragment;

public class FragmentManager extends Activity {
	android.app.FragmentManager fm;
	Fragment fragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragmentmanager);
	}

	public static class TextFragment extends Fragment {
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View root = inflater.inflate(R.layout.textfragment, container, false);
			TextView text = (TextView) root.findViewById(R.id.fragManager_et);
			text.setSaveEnabled(true);
			return root;
		}
	}

	public void mOnClick(View v) {
		fm = getFragmentManager();
		fragment = fm.findFragmentById(R.id.fragManager_frame);

		switch (v.getId()) {
		case R.id.fragManager_btnAdd:
			if (fragment == null) {
				CounterFragment cf = new CounterFragment();
				fm.beginTransaction().add(R.id.fragManager_frame, cf, "counter").commit();
			} else {
				Toast.makeText(this, "이미 추가되어 있습니다.", 0).show();
			}
			break;
		case R.id.fragManager_btnHide:
			if (fragment == null) {
				Toast.makeText(this, "프래그먼트가 없습니다.", 0).show();
			} else {
				FragmentTransaction tr = fm.beginTransaction();
				if (fragment.isHidden()) {
					tr.show(fragment);
				} else {
					tr.hide(fragment);
				}
				tr.commit();
			}
			break;
		case R.id.fragManager_btnRemove:
			if (fragment == null) {
				Toast.makeText(this, "프래그먼트가 없습니다.", 0).show();
			} else {
				fm.beginTransaction().remove(fragment).commit();
			}
			break;

		case R.id.fragManager_btnReplace:
			if(fragment == null){
				Toast.makeText(this, "프래그먼트가 없습니다.", 0).show();
			}else{
				FragmentTransaction tr = fm.beginTransaction();
				if(fragment.getTag().equalsIgnoreCase("counter")){
					TextFragment tf = new TextFragment();
					tr.replace(R.id.fragManager_frame, tf, "text");
				}else{
					CounterFragment cf = new CounterFragment();
					tr.replace(R.id.fragManager_frame, cf, "counter");
				}
				tr.commit();
			}
			break;
		}
	}
}
