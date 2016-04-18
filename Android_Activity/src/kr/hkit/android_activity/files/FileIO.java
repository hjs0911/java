package kr.hkit.android_activity.files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import kr.hkit.android_activity.R;

public class FileIO extends Activity {
	private EditText mEdit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fileio);

		mEdit = (EditText) findViewById(R.id.etFilee);
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.Info_btnSave:
			try {
				FileOutputStream fos = openFileOutput("test.txt", Context.MODE_PRIVATE);
				String str = mEdit.getText().toString();
				fos.write(str.getBytes());
				fos.close();
				mEdit.setText("write success");
			} catch (Exception e) {
				;
			}
			break;

		case R.id.btnLoad:
			FileInputStream fis;
			try {
				fis = openFileInput("test.txt");
				byte[] data = new byte[fis.available()];
				fis.read(data);
				fis.close();
				mEdit.setText(new String(data));
			} catch (Exception e) {
				;
			}
			break;
			
		case R.id.btnLoadRes:
			try{
			InputStream fres = getResources().openRawResource(R.raw.restext);
			byte[] data = new byte[fres.available()];
			fres.read(data);
			fres.close();
			mEdit.setText(new String(data));
			}catch(Exception e){;}
			break;
		case R.id.btnDelete:
			if(deleteFile("test.txt")){
				mEdit.setText("delete success");
			}else{
				mEdit.setText("delete failed");
			}
			break;
		}
	}
}
