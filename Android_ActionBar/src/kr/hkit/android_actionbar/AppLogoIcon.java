package kr.hkit.android_actionbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class AppLogoIcon extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView text = new TextView(this);
		text.setText("타이틀 바의 로고 아이콘을 누르세요.");
		setContentView(text);
		getActionBar().setHomeButtonEnabled(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.ond:
			Toast.makeText(this, "첫번째 액션 항목 선택", 0).show();
			return true;

		case android.R.id.home:
			Toast.makeText(this, "로고 아이콘 선택", 0).show();
			Intent intent = new Intent(this, MainActivity.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			return true;
		}
		
		return false;
	}
}
