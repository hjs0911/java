package kr.hkit.android_thread;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AbsListView.LayoutParams;
import kr.hkit.android_thread.ani.TouchAni;
import kr.hkit.android_thread.ani.TweenAni;

public class MainActivity extends ListActivity {
	private String[] lists = {"쓰레드1", "트윈애니", "터치애니", "숙제1"};
	private Class[] classes = {MyThread.class, TweenAni.class, TouchAni.class, Study23.class};
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		MyListAdapter adapter = new MyListAdapter();
		setListAdapter(adapter);
		ListView list = getListView();
		list.setPersistentDrawingCache(ViewGroup.PERSISTENT_ALL_CACHES);
		
		AnimationSet set = new AnimationSet(true);
		Animation trl = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
		trl.setDuration(1000);
		set.addAnimation(trl);
		
		Animation alpha = new AlphaAnimation(0.0f, 1.0f);
		alpha.setDuration(1000);
		set.addAnimation(alpha);
		
		LayoutAnimationController controllor = new LayoutAnimationController(set, 0.5f);
		list.setLayoutAnimation(controllor);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = new Intent(this, classes[position]);
		startActivity(intent);
	}
	
	class MyListAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return lists.length;
		}

		@Override
		public Object getItem(int position) {
			return lists[position];
		}

		@Override
		public long getItemId(int position) {
			return position;
		}
		
		private TextView getGenericview() {
			AbsListView.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100);
			
			TextView tv = new TextView(getApplicationContext());
			tv.setLayoutParams(params);
			tv.setGravity(Gravity.CENTER_VERTICAL|Gravity.START);
			tv.setPadding(80, 0, 0, 0);
			tv.setTextColor(Color.RED);
			tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
			return tv;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			TextView tv = getGenericview();
			tv.setText(lists[position]);
			return tv;
		}
		
	}
}
