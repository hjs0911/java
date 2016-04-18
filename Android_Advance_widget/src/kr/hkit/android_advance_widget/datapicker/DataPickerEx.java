package kr.hkit.android_advance_widget.datapicker;

import java.util.Calendar;
import java.util.GregorianCalendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import kr.hkit.android_advance_widget.R;

public class DataPickerEx extends Activity {
	int mYear, mMonth, mDay, mHour, mMinute;
	TextView mTxtDate, mTxtTime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datapickerex);
		
		mTxtDate = (TextView) findViewById(R.id.txtData);
		mTxtTime = (TextView) findViewById(R.id.txtTime);
		
		Calendar cal = new GregorianCalendar();
		mYear = cal.get(Calendar.YEAR);
		mMonth = cal.get(Calendar.MONTH);
		mDay = cal.get(Calendar.DAY_OF_MONTH);
		mHour = cal.get(Calendar.HOUR_OF_DAY);
		mMinute = cal.get(Calendar.MINUTE);
		
		updateNow();
	}

	private void updateNow() {
		String dateTxt = String.format("%d/%d/%d", mYear, mMonth+1, mDay);
		mTxtDate.setText(dateTxt);
		String timeTxt = String.format("%d:%d", mHour, mMinute);
		mTxtTime.setText(timeTxt);
	}
	
	public void mOnClick(View v){
		switch(v.getId()){
		case R.id.btnChangeData:
			new DatePickerDialog(DataPickerEx.this, mDateSetListener, mYear, mMonth, mDay).show();
			break;
		case R.id.btnChangeTime:
			new TimePickerDialog(DataPickerEx.this, mTimeSetListener, mHour, mMinute, false).show();
			break;
		}
	}
	
	DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
			mYear = year;
			mMonth = monthOfYear;
			mDay = dayOfMonth;
			updateNow();
			
		}
	};
	
	TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
		
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			mHour = hourOfDay;
			mMinute = minute;
			updateNow();
			
		}
	};
}
