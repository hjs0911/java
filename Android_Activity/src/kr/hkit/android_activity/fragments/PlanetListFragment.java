package kr.hkit.android_activity.fragments;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import kr.hkit.android_activity.R;

public class PlanetListFragment extends ListFragment{
	String[] planets;
	int mLastIndex;
	boolean mMultiPane;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		planets = getResources().getStringArray(R.array.planet);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, planets));
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		if(savedInstanceState != null){
			mLastIndex = savedInstanceState.getInt("lastindex");
		}
		
		/*View descPanel = getActivity().findViewById(R.id.multipanewidth_descpanel);
		if(descPanel != null && descPanel.getVisibility() == View.VISIBLE){
			mMultiPane = true;
			onListItemClick(getListView(), null, mLastIndex, 0);
		}*/
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("lastindex", mLastIndex);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		mLastIndex = position;
		getListView().setItemChecked(position, true);
		
		if(mMultiPane){
			android.app.FragmentManager fm = getFragmentManager();
		}
	}
}
