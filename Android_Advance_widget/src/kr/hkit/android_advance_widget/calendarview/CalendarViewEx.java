package kr.hkit.android_advance_widget.calendarview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;
import kr.hkit.android_advance_widget.R;

public class CalendarViewEx extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calendarviewex);
		
		CalendarView calendar = (CalendarView) findViewById(R.id.calendarView1);
		calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
			
			@Override
			public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
				String text = year + "/" + (month + 1) + "/" + dayOfMonth;
				Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
				
			}
		});
	}
}
