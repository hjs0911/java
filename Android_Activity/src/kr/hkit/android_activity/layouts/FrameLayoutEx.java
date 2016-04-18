package kr.hkit.android_activity.layouts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import kr.hkit.android_activity.R;

public class FrameLayoutEx extends Activity {
	private ImageView image1, image2, image3;
	private int index;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.framelayoutex);
		
		index = 0;
		image1 = (ImageView) findViewById(R.id.image1);
		image2 = (ImageView) findViewById(R.id.image2);
		image3 = (ImageView) findViewById(R.id.image3);

		findViewById(R.id.btnImageChange).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(index == 0){
					image1.setVisibility(View.VISIBLE);
					image2.setVisibility(View.GONE);
					image3.setVisibility(View.GONE);
				}else if(index == 1){
					image1.setVisibility(View.GONE);
					image2.setVisibility(View.VISIBLE);
					image3.setVisibility(View.GONE);
				}else if(index == 2){
					image1.setVisibility(View.GONE);
					image2.setVisibility(View.GONE);
					image3.setVisibility(View.VISIBLE);
				}
				
				index++;
				if(index > 2){
					index = 0;
				}
			}
		});
	}
}
