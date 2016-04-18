package kr.hkit.android_actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void mOnClick(View v){
		ActionBar ab = getActionBar();
		if(v.getId() != R.id.btntoggle) return;
		if(ab.isShowing()){
			ab.hide();
			((Button)v).setText("show Action Bar");
		}else{
			ab.show();
			((Button)v).setText("Hide Action Bar");
		}
	}
	
	public void Click(View v){
		Intent intent = null;
		switch(v.getId()){
		case R.id.btn_AppLogoIc:
			startActivity(new Intent(this, AppLogoIcon.class));
			break;
		case R.id.btn_ActionProv:
			startActivity(new Intent(this, ActionProviderEx.class));
			break;
		case R.id.btn_DisplayOption:
			startActivity(new Intent(this, DisplayOption.class));
			break;
		case R.id.btn_ActionTab:
			startActivity(new Intent(this, ActionTab.class));
			break;
		}
	}

}
