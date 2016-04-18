package kr.hkit.android_advance_widget.progressbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import kr.hkit.android_advance_widget.R;

public class SeekBarEx extends Activity {
	SeekBar mSeekBar;
	TextView mVolume;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seekbarex);
		
		mSeekBar = (SeekBar) findViewById(R.id.seekVolume);
		mVolume = (TextView) findViewById(R.id.volume);
		
		mSeekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				mVolume.setText("Now Volume : " + progress);
				
			}
		});
	}
}
