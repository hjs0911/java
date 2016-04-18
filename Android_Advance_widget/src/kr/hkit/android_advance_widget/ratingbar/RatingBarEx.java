package kr.hkit.android_advance_widget.ratingbar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import kr.hkit.android_advance_widget.R;
import kr.hkit.android_advance_widget.R.id;
import kr.hkit.android_advance_widget.R.layout;
import android.widget.TextView;

public class RatingBarEx extends Activity {
	RatingBar mRating;
	TextView mRateText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ratingbarex);
		
		mRating = (RatingBar) findViewById(R.id.rtBar01);
		mRateText = (TextView) findViewById(R.id.tvRate);
		
		mRating.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			
			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating, 
					boolean fromUser) {
				mRateText.setText("Now Rate : " + rating);
			}
		});
	}
}
