package kr.hkit.android_activity.files;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class PrefTest extends Activity {
	private TextView textName, textStNum;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.preftest);
		
		textName = (TextView) findViewById(R.id.pref_etName);
		textStNum = (TextView) findViewById(R.id.pref_etNum);
		
		SharedPreferences pref = getSharedPreferences("PrefTest", 0);
		String Name = pref.getString("Name", "이름없음");
		textName.setText(Name);
		
		int StNum = pref.getInt("StNum", 20101234);
		textStNum.setText("" + StNum);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		
		SharedPreferences pref = getSharedPreferences("PrefTest", 0);
		SharedPreferences.Editor edit = pref.edit();
		String Name = textName.getText().toString();
		int StNum = 0;
		try{
		StNum = Integer.parseInt(textStNum.getText().toString());
		}catch(Exception e){}
		edit.putString("Name", Name);
		edit.putInt("StNum", StNum);
		edit.commit();
	}
}
