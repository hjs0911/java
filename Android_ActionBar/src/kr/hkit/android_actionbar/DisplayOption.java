package kr.hkit.android_actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class DisplayOption extends Activity {
	CheckBox mChkUseLogo, mChkShowHome, mChkHomeAsUp, mChkShowTitle, mChkShowCustom;
	ActionBar mActionBar;
	Button mCustom;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.displayoption);
		
		mChkUseLogo = (CheckBox) findViewById(R.id.chkUseLogo);
		mChkUseLogo.setOnCheckedChangeListener(mListener);
		mChkShowHome = (CheckBox) findViewById(R.id.chkShowHome);
		mChkShowHome.setOnCheckedChangeListener(mListener);
		mChkHomeAsUp = (CheckBox) findViewById(R.id.chkHomeAsUp);
		mChkHomeAsUp.setOnCheckedChangeListener(mListener);
		mChkShowTitle = (CheckBox) findViewById(R.id.chkShowTitle);
		mChkShowTitle.setOnCheckedChangeListener(mListener);
		mChkShowCustom = (CheckBox) findViewById(R.id.chkShowCustom);
		mChkShowCustom.setOnCheckedChangeListener(mListener);
		
		mActionBar = getActionBar();
		mCustom = new Button(this);
		mCustom.setText("Custom");
		mActionBar.setCustomView(mCustom);
		
		mActionBar.setSubtitle("subtitle");
		
		int option = mActionBar.getDisplayOptions();
		mChkUseLogo.setChecked((option & ActionBar.DISPLAY_USE_LOGO) != 0);
		mChkShowHome.setChecked((option & ActionBar.DISPLAY_SHOW_HOME) != 0);
		mChkHomeAsUp.setChecked((option & ActionBar.DISPLAY_HOME_AS_UP) != 0);
		mChkShowTitle.setChecked((option & ActionBar.DISPLAY_SHOW_TITLE) != 0);
		mChkShowCustom.setChecked((option & ActionBar.DISPLAY_SHOW_CUSTOM) != 0);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		
		return true;
	}
	
	OnCheckedChangeListener mListener = new OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			switch(buttonView.getId()){
			case R.id.chkUseLogo:
				mActionBar.setDisplayUseLogoEnabled(isChecked);
				break;
			case R.id.chkShowHome:
				mActionBar.setDisplayShowHomeEnabled(isChecked);
				break;
			case R.id.chkHomeAsUp:
				mActionBar.setDisplayHomeAsUpEnabled(isChecked);
				break;
			case R.id.chkShowTitle:
				mActionBar.setDisplayShowTitleEnabled(isChecked);
				break;
			case R.id.chkShowCustom:
				mActionBar.setDisplayShowCustomEnabled(isChecked);
				break;
			}
		}
	};
}
