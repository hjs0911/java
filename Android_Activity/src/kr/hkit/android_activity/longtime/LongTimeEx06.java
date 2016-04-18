package kr.hkit.android_activity.longtime;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class LongTimeEx06 extends Activity {
	int mValue;
	TextView mText;
	ProgressDialog mProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.longtimeex);
		mText = (TextView) findViewById(R.id.tvTime);
	}

	public void mOnClick(View v) {
		new AccumlateTask().execute(100);
	}

	class AccumlateTask extends AsyncTask<Integer, Integer, Integer[]> {

		@Override
		protected void onPreExecute() {
			if (Integer.parseInt(mText.getText().toString()) == 100) {
				mText.setText(0 + "");
				mValue = 0;
			}
			mProgress = new ProgressDialog(LongTimeEx06.this);
			mProgress.setTitle("Updating");
			mProgress.setMessage("Wait...");
			mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			mProgress.setProgress(mValue);
			mProgress.setOnCancelListener(new ProgressDialog.OnCancelListener() {

				@Override
				public void onCancel(DialogInterface dialog) {
					cancel(true);
				}
			});
			mProgress.show();
		}

		@Override
		protected void onPostExecute(Integer result[]) {
			mProgress.dismiss();
			// mText.setText(Integer.toString(mResult));
			mText.setText(String.format("홀수의 합 : %d 짝수의 합: %d 총합:%d", result[0], result[1], (result[0] + result[1])));
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			mProgress.setProgress(values[0]);
		}

		@Override
		protected Integer[] doInBackground(Integer... params) {
			Integer[] arr = { 0, 0 };
			while (!isCancelled()) {
				mValue++;
				if (mValue < params[0] + 1) {
					publishProgress(mValue);
					if (mValue % 2 == 0) {
						arr[1] += mValue;
					} else {
						arr[0] += mValue;
					}
				} else {
					break;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
				}

			}
	
			return arr;
		}

		@Override
		protected void onCancelled() {
			mProgress.dismiss();
			mValue = 0;
		}

	}
}
