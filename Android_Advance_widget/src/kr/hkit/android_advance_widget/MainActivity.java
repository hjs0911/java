package kr.hkit.android_advance_widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import kr.hkit.android_advance_widget.calendarview.CalendarViewEx;
import kr.hkit.android_advance_widget.datapicker.DataPickerEx;
import kr.hkit.android_advance_widget.listpopup.ListPopupEx;
import kr.hkit.android_advance_widget.numberpicker.NumberPickerEx;
import kr.hkit.android_advance_widget.progressbar.ProgressBarEx;
import kr.hkit.android_advance_widget.progressbar.ProgressBarEx2;
import kr.hkit.android_advance_widget.progressbar.ProgressBarEx3;
import kr.hkit.android_advance_widget.progressbar.SeekBarEx;
import kr.hkit.android_advance_widget.ratingbar.RatingBarEx;
import kr.hkit.android_advance_widget.space.SpaceEx;
import kr.hkit.android_advance_widget.switchex.SwitchEx;
import kr.hkit.android_advance_widget.webview.WebViewEx;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void btnOnClick(View v) {

		switch (v.getId()) {
		case R.id.btn01:
			startActivity(new Intent(this, ProgressBarEx.class));
			break;
		case R.id.btn02:
			startActivity(new Intent(this, ProgressBarEx2.class));
			break;
		case R.id.btn03:
			startActivity(new Intent(this, ProgressBarEx3.class));
			break;
		case R.id.btn04:
			startActivity(new Intent(this, SeekBarEx.class));
			break;
		case R.id.btn05:
			startActivity(new Intent(this, RatingBarEx.class));
			break;
		case R.id.btn06:
			startActivity(new Intent(this, DataPickerEx.class));
			break;
		case R.id.btn07:
			startActivity(new Intent(this, WebViewEx.class));
			break;
		case R.id.btn08:
			startActivity(new Intent(this, SwitchEx.class));
			break;
		case R.id.btn09:
			startActivity(new Intent(this, SpaceEx.class));
			break;
		case R.id.btn10:
			startActivity(new Intent(this, NumberPickerEx.class));
			break;
		case R.id.btn11:
			startActivity(new Intent(this, CalendarViewEx.class));
			break;
		case R.id.btn12:
			startActivity(new Intent(this, ListPopupEx.class));
			break;
		}
	}
}
