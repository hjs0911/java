package kr.hkit.android_activity;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import kr.hkit.android_activity.activity.CallAdd;
import kr.hkit.android_activity.activity.CallOther;
import kr.hkit.android_activity.activity.CommActivity;
import kr.hkit.android_activity.files.FileIO;
import kr.hkit.android_activity.files.MyFileEx01;
import kr.hkit.android_activity.files.PrefActivity;
import kr.hkit.android_activity.files.PrefTest;
import kr.hkit.android_activity.files.SDCard;
import kr.hkit.android_activity.fragments.CounterFragment;
import kr.hkit.android_activity.fragments.FragmentArgument;
import kr.hkit.android_activity.fragments.FragmentLifeCycle;
import kr.hkit.android_activity.fragments.FragmentManager;
import kr.hkit.android_activity.fragments.ListFragment;
import kr.hkit.android_activity.fragments.ListFragmentDivide;
import kr.hkit.android_activity.fragments.ReuseFragment;
import kr.hkit.android_activity.fragments.WordListFragment;
import kr.hkit.android_activity.interfaces.Calculator;
import kr.hkit.android_activity.itents.IntentEx;
import kr.hkit.android_activity.layouts.FrameLayoutEx;
import kr.hkit.android_activity.layouts.StudentProfil;
import kr.hkit.android_activity.listviews.ListViewEx01;
import kr.hkit.android_activity.listviews.ListViewEx02;
import kr.hkit.android_activity.listviews.ListViewEx03;
import kr.hkit.android_activity.longtime.LongTimeEx;
import kr.hkit.android_activity.longtime.LongTimeEx02;
import kr.hkit.android_activity.longtime.LongTimeEx03;
import kr.hkit.android_activity.longtime.LongTimeEx04;
import kr.hkit.android_activity.longtime.LongTimeEx05;
import kr.hkit.android_activity.longtime.LongTimeEx06;
import kr.hkit.android_activity.longtime.LongTimeEx07;
import kr.hkit.android_activity.longtime.LongTimeEx08;
import kr.hkit.android_activity.schedule.PostDelayedEx;
import kr.hkit.android_activity.schedule.SendEmptyDelayedEx;
import kr.hkit.android_activity.schedule.UploadEx01;
import kr.hkit.android_activity.schedule.ViewPostDelayedEx;
import kr.hkit.android_activity.state.SaveCurve;
import kr.hkit.android_activity.state.SavaState02;
import kr.hkit.android_activity.state.SavaState03;
import kr.hkit.android_activity.state.SaveState01;
import kr.hkit.android_activity.thread.HandlerEx;
import kr.hkit.android_activity.thread.Handler_PostEx;
import kr.hkit.android_activity.thread.LooperEx;
import kr.hkit.android_activity.thread.ThreadEx01;

public class MainActivity extends ExpandableListActivity {
	private String[] strArrGroups = {"액티비티", "생명주기", "스레드", "스케줄링", "스케줄링 활용", "파일입출력", "인텐트", "레이아웃", "인터페이스", "리스트뷰", "프레그먼트"};
	private String[][] strArrchilds = {{"ActivityForResult", "묵시적 인텐트", "인텐트 필터", "액티비티라이프사이클"},
										{"상태저장01", "상태저장02", "상태저장03", "자유곡선"},
										{"스레드01", "핸들러", "핸들러2", "루퍼"},
										{"작업스케줄링01", "작업스케줄링02", "작업스케줄링03", "작업스케줄링04"},
										{"롱타임01", "롱타임02", "롱타임03", "롱타임04", "롱타임05", "롱타임06", "롱타임07", "롱타임08"},
										{"파일01", "파일02", "파일03", "파일04", "교재, 파일01"},
										{"인텐트01"},
										{"프레임 레이아웃", "학생프로필"},
										{"계산기"},
										{"리스트뷰01", "리스트뷰02", "리스트뷰03"},
										{"프레그먼트01", "프레그먼트 재사용", "프레그먼트02", "프레그먼트03", "프래그먼트04", "프레그먼트05"}};
	private Class[][] clsSrrClasses = {{CommActivity.class, CallOther.class, CallAdd.class, ActParent.class},
										{SaveState01.class, SavaState02.class, SavaState03.class, SaveCurve.class},
										{ThreadEx01.class, HandlerEx.class, Handler_PostEx.class, LooperEx.class},
										{UploadEx01.class, SendEmptyDelayedEx.class, PostDelayedEx.class, ViewPostDelayedEx.class},
										{LongTimeEx.class, LongTimeEx02.class, LongTimeEx03.class, LongTimeEx04.class, LongTimeEx05.class, LongTimeEx06.class, LongTimeEx07.class, LongTimeEx08.class},
										{FileIO.class, SDCard.class, PrefTest.class, PrefActivity.class, MyFileEx01.class},
										{IntentEx.class},
										{FrameLayoutEx.class, StudentProfil.class},
										{Calculator.class},
										{ListViewEx01.class, ListViewEx02.class, ListViewEx03.class},
										{FragmentLifeCycle.class, ReuseFragment.class, FragmentManager.class, FragmentArgument.class, ListFragment.class, ListFragmentDivide.class}};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyExpandableListAdapter adapter = new MyExpandableListAdapter();
		setListAdapter(adapter);
	}
	
	@Override
	public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
		Intent intent = new Intent(getApplicationContext(), clsSrrClasses[groupPosition][childPosition]);
		startActivity(intent);
		return true;
	}
	
	public class MyExpandableListAdapter extends BaseExpandableListAdapter{

		@Override
		public int getGroupCount() {
			return strArrGroups.length;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return strArrchilds[groupPosition].length;
		}

		@Override
		public Object getGroup(int groupPosition) {
			return strArrGroups[groupPosition];
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return strArrchilds[groupPosition][childPosition];
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public boolean hasStableIds() {
			return true;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
			TextView tv = getGenericview();
			tv.setText(getGroup(groupPosition).toString());
			return tv;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
				ViewGroup parent) {
			TextView tv = getGenericview();
			tv.setPadding(120, 0, 0, 0);
			tv.setTextColor(Color.BLACK);
			tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
			tv.setText(getChild(groupPosition, childPosition).toString());
			return tv;
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
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			return true;
		}
		
	}
}
