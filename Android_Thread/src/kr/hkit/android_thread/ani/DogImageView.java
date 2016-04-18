package kr.hkit.android_thread.ani;

import java.util.ArrayList;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import kr.hkit.android_thread.R;

public class DogImageView extends ImageView {
	Handler handler = new Handler();
	
	public DogImageView(Context context) {
		super(context);
	}
	
	public DogImageView(Context context, AttributeSet attrs){
		super(context, attrs);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		TouchThread thread = new TouchThread();
		thread.start();
		return true;
	}
	
	class TouchThread extends Thread{
		int stateIdx;
		
		ArrayList<Integer> images = new ArrayList<Integer>();

		public TouchThread() {
			images.add(R.drawable.dog_standing);
			images.add(R.drawable.dog_running);
			images.add(R.drawable.dog_biting);
		}
		
		@Override
		public void run() {
			stateIdx = 0;
			for(int i=0; i<20; i++){
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						setImageResource(images.get(stateIdx));
					}
				});
				
				try{Thread.sleep(500);}catch(InterruptedException e){}
				stateIdx++;
				if(stateIdx >= images.size()){
					stateIdx = 0;
				}
			}
		}
		
		
	}
}
