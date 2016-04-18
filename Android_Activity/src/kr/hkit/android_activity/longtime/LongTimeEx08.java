package kr.hkit.android_activity.longtime;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import kr.hkit.android_activity.R;

public class LongTimeEx08 extends Activity {
	private ProgressDialog mProgress;
	private int mValue;
	private TextView textView;
	private EditText etLeft;
	private EditText etRight;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.longtime08);
		textView = (TextView) findViewById(R.id.gugudan);
		etLeft = (EditText) findViewById(R.id.tvDan1);
		etRight = (EditText) findViewById(R.id.tvDan2);
	}
	
	public void mOnClick(View v){
		textView.setText("");
		Integer start = null;
		Integer end = null;
		try{
			start = Integer.parseInt(etLeft.getText().toString());
			end = Integer.parseInt(etRight.getText().toString());
		}catch(NumberFormatException e){
			end = null;
		}
		new AccumulateTask().execute(start, end);
	}
	
	class AccumulateTask extends AsyncTask<Integer, String, Void>{
		
		@Override
		protected void onPreExecute() {
			mProgress = new ProgressDialog(LongTimeEx08.this);
			mProgress.setTitle("Updating");
			mProgress.setMessage("Wait...");
			mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			mProgress.setCancelable(true);
			mProgress.setProgress(mValue);
			mProgress.setOnCancelListener(new DialogInterface.OnCancelListener() {
				@Override
				public void onCancel(DialogInterface dialog) {
					cancel(true);
				}
			});
			mProgress.show();
		}
		
		@Override
		protected Void doInBackground(Integer... params) {
			int startDan = params[0];
			int endDan;
			StringBuilder str = new StringBuilder();
			if (params[1]!=null){
				endDan = params[1];
			}else{
				endDan = params[0];
			}
			int dif = endDan - startDan;
			if (dif==0)dif =1;
			int ratio = 100/(dif*9);
			for(int i=startDan ; i<endDan + 1; i++){
				for(int j=1; j<10; j++){
					publishProgress(String.format("%2d * %2d = %2d%n", i, j, i*j), String.valueOf(mValue));
					mValue += ratio;
					try {Thread.sleep(50);} catch (InterruptedException e) {}
				}
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			mProgress.dismiss();
			mValue = 0;
		}
		
		@Override
		protected void onProgressUpdate(String... values) {
			mProgress.setProgress(Integer.parseInt(values[1]));
			textView.append(values[0]);
		}
		
		@Override
		protected void onCancelled() {
			mProgress.dismiss();
		}
	}
}
