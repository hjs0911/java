package kr.hkit.android_actionbar;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.os.Bundle;

public class ActionTab extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actiontab);
		
		ActionBar ab = getActionBar();
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		for(int i=0; i<3; i++){
			ActionBar.Tab tab = ab.newTab();
			String Cap = "Tab" + (i + 1);
			tab.setText(Cap);
			TabFragment frag = TabFragment.newInstance(Cap);
			tab.setTabListener(new TabListener(frag));
			ab.addTab(tab);
		}
		
		if(savedInstanceState != null){
			int seltab = savedInstanceState.getInt("seltab");
			ab.setSelectedNavigationItem(seltab);
		}
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("seltab", getActionBar().getSelectedNavigationIndex());
	}
}
