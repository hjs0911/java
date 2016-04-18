package kr.hkit.android_thread;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MyThread extends Activity {
	ImageView imageView1;
	ImageView imageView2;
	EditText editText;

	Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageView1 = (ImageView) findViewById(R.id.imgDog);
		imageView2 = (ImageView) findViewById(R.id.img_Dog02);
		editText = (EditText) findViewById(R.id.editText1);

		Button btn = (Button) findViewById(R.id.btnStart);
		btn.setOnClickListener(listener);

	}

	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			DogThread thread1 = new DogThread(0);
			thread1.start();
			DogThread thread2 = new DogThread(1);
			thread2.start();
		}
	};

	class DogThread extends Thread {
		int dogIndex; // 0 또는 1 Thread구분을 위한 인덱스
		int stateIndex;

		ArrayList<Integer> images = new ArrayList<Integer>();

		public DogThread(int index) {
			this.dogIndex = index;

			images.add(R.drawable.dog_standing);
			images.add(R.drawable.dog_running);
			images.add(R.drawable.dog_biting);
		}

		@Override
		public void run() {
			stateIndex = 0;

			for (int i = 0; i < 9; i++) {
				final String msg = String.format("dog #%d state : %d%n", dogIndex, stateIndex);
				handler.post(new Runnable() {

					@Override
					public void run() {
						editText.append(msg);

						if (dogIndex == 0) {
							imageView1.setImageResource(images.get(stateIndex)); // 메인스레드에서만
																					// ui접근가능
						} else if (dogIndex == 1) {
							imageView2.setImageResource(images.get(stateIndex));
						}

					}
				});

				int sleepTime = getRandomTime(500, 3000);
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				stateIndex++;
				if (stateIndex >= images.size()) {
					stateIndex = 0;
				}
			}
		}// end of method run()
	}

	public int getRandomTime(int min, int max) {
		return min + (int) (Math.random() * (max - min));
	}
}
