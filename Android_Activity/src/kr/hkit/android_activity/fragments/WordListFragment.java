package kr.hkit.android_activity.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import kr.hkit.android_activity.R;

public class WordListFragment extends ListFragment {
	OnWordChangeListener mListener;

	public interface OnWordChangeListener {
		void onWordChanged(int index);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		try {
			mListener = (OnWordChangeListener) activity;
		} catch (ClassCastException e) {
			throw new ClassCastException("activity must implements OnWordChangeListener");
		}
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), 
				R.array.word, android.R.layout.simple_list_item_1);
		setListAdapter(adapter);
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		mListener.onWordChanged(position);
	}
}
