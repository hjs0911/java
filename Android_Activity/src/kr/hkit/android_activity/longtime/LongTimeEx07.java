package kr.hkit.android_activity.longtime;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import kr.hkit.android_activity.R;

public class LongTimeEx07 extends Activity {
	EditText etStart;
	EditText etEnd;
	TextView tvResult;
	ProgressDialog mProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.longtime6);
		etStart = (EditText) findViewById(R.id.etLongStart);
		etEnd = (EditText) findViewById(R.id.etLongEnd);
		tvResult = (TextView) findViewById(R.id.tvLongTimeResult);

	}

	public void mOnClick(View v) {
		int startNum = 0, endNum = 0;
		try {
			startNum = Integer.parseInt(etStart.getText().toString());
			endNum = Integer.parseInt(etEnd.getText().toString());
			if (startNum - endNum > 0) {
				throw new Exception();
			}
			new MyAsync().execute(startNum, endNum);

		} catch (Exception e) {
			Toast.makeText(this, "숫자로 입력해주세요", Toast.LENGTH_SHORT).show();
		}

	}

	class MyAsync extends AsyncTask<Integer, Integer, Integer[]> {

		@Override
		protected Integer[] doInBackground(Integer... params) {
			Integer arr[] = { 0, 0, 0, 0 };

			for (int i = params[0]; i <= params[1] && !isCancelled(); i++) {
				if (i % 2 == 0) {
					arr[1] = arr[1] + i;
				} else {
					arr[0] = arr[0] + i;
				}
				arr[2] += 1;
				arr[3] = (int) ((double) arr[2] * 100 / (params[1] - params[0]));
				publishProgress(arr[3]);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
				}

			}

			return arr;
		}

		@Override
		protected void onPreExecute() {

			mProgress = new ProgressDialog(LongTimeEx07.this);
			mProgress.setTitle("계산");
			mProgress.setMessage("홀수와 짝수값을 구합니다.");
			mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			mProgress.setProgress(0);
			mProgress.setOnCancelListener(new ProgressDialog.OnCancelListener() {

				@Override
				public void onCancel(DialogInterface dialog) {
					cancel(true);
				}
			});
			mProgress.show();
		}

		@Override
		protected void onPostExecute(Integer[] result) {
			mProgress.dismiss();
			tvResult.setText(
					String.format("홀수의 합 : %d 짝수의 합: %d 총합:%d", result[0], result[1], (result[0] + result[1])));

		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			mProgress.setProgress(values[0]);
		}

		@Override
		protected void onCancelled() {
			mProgress.dismiss();

		}

	}
}
