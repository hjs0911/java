package kr.hkit.android_activity.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import kr.hkit.android_activity.R;

public class CommActivity extends Activity {
	public static final int ACT_EDIT = 0;
	public static final int ACT_FONT = 1;
	Intent intent;
	
	private TextView tv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commactivity);
		tv = (TextView) findViewById(R.id.tv);
	}
	
	public void mOnClick(View v){
		if(v.getId() == R.id.btnEdit){
			intent = new Intent(this, EditAtivity.class);
			intent.putExtra("TextIn", tv.getText().toString());
			startActivityForResult(intent, ACT_EDIT);
		}else if(v.getId() == R.id.btnFont){
			intent = new Intent(this, FontActivity.class);
			startActivityForResult(intent, ACT_FONT);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode){
		case ACT_EDIT:
			if(resultCode == RESULT_OK){
				tv.setText(data.getStringExtra("TextOut"));
			}else{
				Toast.makeText(this, "편집 취소", Toast.LENGTH_SHORT).show();
			}
			break;
		case ACT_FONT:
			if(requestCode == RESULT_OK){
			}
			break;
		}
	}
}
