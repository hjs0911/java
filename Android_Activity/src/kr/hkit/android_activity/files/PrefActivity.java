package kr.hkit.android_activity.files;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import kr.hkit.android_activity.R;

public class PrefActivity extends PreferenceActivity {
	@SuppressWarnings("deprecation")
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.prefactivity);
	}
}
