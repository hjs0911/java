package kr.hkit.android_activity.listviews;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import kr.hkit.android_activity.R;

public class ListViewEx01 extends ListActivity {
	//원본
	String[] names = {"소녀시대", "티아라", "걸스데이", "아이유", "애프터스쿨"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Toast.makeText(this, names[position], Toast.LENGTH_SHORT).show();
	}
}
