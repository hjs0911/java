package kr.hkit.android_activity.fragments;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import kr.hkit.android_activity.R;

public class ListFragment extends Activity {
	static String[] WORDS;
	static String[] DESC;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		WORDS = getResources().getStringArray(R.array.word);
		DESC = getResources().getStringArray(R.array.desc);
		FragmentManager fm = getFragmentManager();
		if(fm.findFragmentById(android.R.id.content) == null){
			WordListFragment wordList = new WordListFragment();
			fm.beginTransaction().add(android.R.id.content, wordList).commit();
		}
	}
	
	public static class WordListFragment extends android.app.ListFragment{
		
		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			super.onActivityCreated(savedInstanceState);
			setListAdapter(new ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_list_item_1, WORDS));
		}
		
		@Override
		public void onListItemClick(ListView l, View v, int position, long id) {
			String text = WORDS[position] +  " : " + DESC[position];
			Toast.makeText(getActivity(), text, 0).show();	
		}
	}
}
