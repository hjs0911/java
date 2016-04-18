package kr.hkit.android_advance_widget.listpopup;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import kr.hkit.android_advance_widget.R;

public class ListPopupEx extends Activity {
	LinearLayout mBtn;
	ListPopupWindow mList;
	public String[] Colors = {"Red", "Green", "Blue", "Yellow", "Cyan", "Magenta"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listpopupex);
		
		mBtn = (LinearLayout) findViewById(R.id.linear);
		mList = new ListPopupWindow(this);
		mList.setWidth(300);
		mList.setHeight(300);
		mList.setAnchorView(mBtn);
		mList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Colors));
		mList.setModal(true);
		
		mList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				switch(position){
				case 0: mBtn.setBackgroundColor(Color.RED); break;
				case 1: mBtn.setBackgroundColor(Color.GREEN); break;
				case 2: mBtn.setBackgroundColor(Color.BLUE); break;
				case 3: mBtn.setBackgroundColor(Color.YELLOW); break;
				case 4: mBtn.setBackgroundColor(Color.CYAN); break;
				case 5: mBtn.setBackgroundColor(Color.MAGENTA); break;
				}
				
			}
		});
	}
	
	public void Click(View v){
		if(mList.isShowing()){
			mList.dismiss();
		}else{
			mList.show();
		}
	}
}
