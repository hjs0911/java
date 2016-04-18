package kr.hkit.android_advance_widget.numberpicker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.Toast;
import kr.hkit.android_advance_widget.R;

public class NumberPickerEx extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.numberpickerex);
		
		NumberPicker picker1 = (NumberPicker) findViewById(R.id.Picker1);
		picker1.setMinValue(0);
		picker1.setMaxValue(5);
		picker1.setWrapSelectorWheel(false);
		
		NumberPicker picker2 = (NumberPicker) findViewById(R.id.Picker2);
		picker2.setMinValue(0);
		picker2.setMaxValue(20);
		picker2.setValue(10);
		picker2.setOnLongPressUpdateInterval(100);
		
		NumberPicker picker3 = (NumberPicker) findViewById(R.id.Picker3);
		picker3.setMinValue(0);
		picker3.setMaxValue(6);
		picker3.setDisplayedValues(
				new String[] {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"}
						);
		
		NumberPicker picker4 = (NumberPicker) findViewById(R.id.Picker4);
		picker4.setMinValue(0);
		picker4.setMaxValue(2);
		picker4.setFormatter(mFormatter);
		
		NumberPicker picker5 = (NumberPicker) findViewById(R.id.Picker5);
		picker5.setMinValue(100);
		picker5.setMaxValue(200);
		picker5.setOnValueChangedListener(new OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				String text = "Value : " + newVal;
				Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
				
			}
		});
	}
	
	NumberPicker.Formatter mFormatter = new NumberPicker.Formatter() {
		
		@Override
		public String format(int value) {
			switch(value){
			case 0:
				return "Zerg";
			case 1:
				return "Terran";
			case 2:
				return "Protoss";
			}
			return null;
		}
	};
}
