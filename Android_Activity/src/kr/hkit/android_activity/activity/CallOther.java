package kr.hkit.android_activity.activity;

import java.io.File;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import kr.hkit.android_activity.R;

public class CallOther extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.callother);
		
		String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
		Toast.makeText(this, sd, Toast.LENGTH_SHORT).show();
	}
	
	public void mOnClick(View v){
		Intent intent = null;
		switch(v.getId()){
		case R.id.web:
			intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
			break;
		case R.id.dial:
			intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:123-123-1234"));
			break;
		case R.id.picture:
			intent = new Intent(Intent.ACTION_VIEW);
			String sd = Environment.getExternalStorageDirectory().getAbsolutePath();
			Uri uri = Uri.fromFile(new File(sd + "/koala.jpg"));
			intent.setDataAndType(uri, "image/jpeg");
			break;
		case R.id.other:
			intent = new Intent(Intent.ACTION_MAIN);
			ComponentName cmpName = new ComponentName("kr.hkit.android_adapter", "kr.hkit.android_adapter.MainActivity");
			intent.setComponent(cmpName);
			break;
		}
		startActivity(intent);
	}
}
