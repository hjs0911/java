package kr.hkit.android_thread.ani;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import kr.hkit.android_thread.R;

public class TweenAni extends Activity {
	ImageView imageView;
	TextView tvResult;
	Animation aniTrans;
	Animation aniRotate;
	Animation aniAlpha;
	Animation aniScale;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tweenani);
	
		imageView = (ImageView) findViewById(R.id.imgDog);
		tvResult = (TextView) findViewById(R.id.tvResult);
		
		aniTrans = AnimationUtils.loadAnimation(TweenAni.this, R.anim.translate);
		aniRotate = AnimationUtils.loadAnimation(TweenAni.this, R.anim.rotate);
		aniAlpha = AnimationUtils.loadAnimation(TweenAni.this, R.anim.alpha);
		aniScale = AnimationUtils.loadAnimation(TweenAni.this, R.anim.scale);
		
		findViewById(R.id.btnStart).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				imageView.startAnimation(aniTrans);
				tvResult.append("애니메이션 시작됨\n");
			}
		});
		
		aniTrans.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {}
			
			@Override
			public void onAnimationRepeat(Animation animation) {}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				imageView.startAnimation(aniRotate);
			}
		});
		
		aniRotate.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				imageView.startAnimation(aniAlpha);
			}
		});
		
		aniAlpha.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				imageView.startAnimation(aniScale);
			}
		});
		
		aniScale.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				Toast.makeText(getApplicationContext(), "Animation End", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
