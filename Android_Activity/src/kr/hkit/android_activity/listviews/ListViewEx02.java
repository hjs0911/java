package kr.hkit.android_activity.listviews;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import kr.hkit.android_activity.R;

class Item {
	String name;
	int age;
	int resId;

	public Item(String name, int age, int resId) {
		this.name = name;
		this.age = age;
		this.resId = resId;
	}

}

public class ListViewEx02 extends ListActivity {
	private ArrayList<Item> arItems = new ArrayList<Item>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initData();
		
		MyListTwoItemAdapter adapter = new MyListTwoItemAdapter();
		setListAdapter(adapter);
	}

	private void initData() {
		arItems.add(new Item("소녀시대", 24, R.drawable.frog));
		arItems.add(new Item("티아라", 32, R.drawable.frog));
		arItems.add(new Item("걸스데이", 24, R.drawable.frog));
		arItems.add(new Item("씨스타", 28, R.drawable.frog));
		arItems.add(new Item("아이유", 22, R.drawable.frog));
	}

	class MyListTwoItemAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			return arItems.size();
		}

		@Override
		public Object getItem(int position) {
			return arItems.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null){
				convertView = getLayoutInflater().inflate(R.layout.items, parent, false);
			}
			Item item = (Item) getItem(position);
			
			ImageView imgPic = (ImageView) convertView.findViewById(R.id.imgPic);
			imgPic.setImageResource(item.resId);
			
			TextView nameTv = (TextView) convertView.findViewById(R.id.tvName);
			TextView ageTv = (TextView) convertView.findViewById(R.id.tvAge);
			nameTv.setText(item.name);
			ageTv.setText(item.age + "");
			return convertView;
		}

	}
}
