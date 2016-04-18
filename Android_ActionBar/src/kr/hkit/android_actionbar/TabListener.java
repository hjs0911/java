package kr.hkit.android_actionbar;

import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;

public class TabListener implements android.app.ActionBar.TabListener {
	private Fragment mFragment;	
	
	
	
	public TabListener(Fragment mFragment) {
		this.mFragment = mFragment;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		ft.add(R.id.tabparent, mFragment, "tag");
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.remove(mFragment);
	}

}
