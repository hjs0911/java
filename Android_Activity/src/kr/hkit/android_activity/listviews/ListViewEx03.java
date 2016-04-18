package kr.hkit.android_activity.listviews;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import kr.hkit.android_activity.R;

class SongItem {
	String songName;
	String singName;
	int singPic;

	public SongItem(String songName, String singName, int singPic) {
		this.songName = songName;
		this.singName = singName;
		this.singPic = singPic;
	}

}

public class ListViewEx03 extends Activity {
	ArrayList<SongItem> arrList = new ArrayList<SongItem>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listviewex);
		
		initData();
		
		SongItemView adapter = new SongItemView();
		ListView list = (ListView) findViewById(R.id.list);
		list.setAdapter(adapter);
		
		findViewById(R.id.btnListClose).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	private void initData() {
		arrList.add(new SongItem("씨스타", "씨스타", R.drawable.frog));
		arrList.add(new SongItem("현아", "현아", R.drawable.frog));
		arrList.add(new SongItem("다비치", "다비치", R.drawable.frog));
		arrList.add(new SongItem("걸스데이", "걸스데이", R.drawable.frog));
		arrList.add(new SongItem("인피니트", "인피니트", R.drawable.frog));
	}

	class SongItemView extends BaseAdapter{

		@Override
		public int getCount() {
			return arrList.size();
		}

		@Override
		public Object getItem(int position) {
			return arrList.get(position);
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
			
			SongItem item = (SongItem) getItem(position);
			
			ImageView image = (ImageView) convertView.findViewById(R.id.imgPic);
			image.setImageResource(item.singPic);
			
			TextView nameTv = (TextView) convertView.findViewById(R.id.tvName);
			nameTv.setText(item.songName);
			
			TextView ageTv = (TextView) convertView.findViewById(R.id.tvAge);
			ageTv.setText(item.singName);
			ageTv.setTextColor(Color.BLUE);
			
			return convertView;
		}
		
	}
}
