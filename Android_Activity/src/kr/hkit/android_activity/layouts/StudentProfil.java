package kr.hkit.android_activity.layouts;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract.Profile;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class StudentProfil extends Activity {
	private ListView list;
	ArrayList<Student> studList = new ArrayList<Student>();
	MyListAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studentprofil);

		list = (ListView) findViewById(R.id.list);
		
		adapter = new MyListAdapter();
		list.setAdapter(adapter);
		list.setOnItemClickListener(itemClickListener);
		
		findViewById(R.id.prof_btnAdd).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(), StudentInfo.class);
				startActivityForResult(intent, 1);
			}
		});
	}
	
	OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			Intent intent = new Intent(getApplicationContext(), StudentInfo.class);
			Student student = studList.get(position);
			intent.putExtra("profile", student);
			startActivity(intent);
		}
	};
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 1 && resultCode == RESULT_OK){
			Student s = (Student) data.getSerializableExtra("profile");
			studList.add(s);
			adapter.notifyDataSetChanged();
		}
	}
	
	class MyListAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return studList.size();
		}

		@Override
		public Object getItem(int position) {
			return studList.get(position);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null){
				LayoutInflater inflator = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = inflator.inflate(R.layout.iteamprofile, parent, false);
			}
			ImageView iv = (ImageView) convertView.findViewById(R.id.profPic);
			TextView tv = (TextView) convertView.findViewById(R.id.profInfo);
			
			Student  student = studList.get(position);
			iv.setImageBitmap(BitmapFactory.decodeFile(student.getImgPath()));
			tv.setText(student.getName() + " : " + student.getAge());
			return convertView;
		}
		
	}
}
