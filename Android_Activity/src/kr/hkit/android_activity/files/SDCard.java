package kr.hkit.android_activity.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import kr.hkit.android_activity.R;

public class SDCard extends Activity {
	private EditText mEdit;
	private String mSdPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sdcard);

		mEdit = (EditText) findViewById(R.id.sdEdit);

		String ext = Environment.getExternalStorageState();
		if (ext.equals(Environment.MEDIA_MOUNTED)) {
			mSdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
		} else {
			mSdPath = Environment.MEDIA_UNMOUNTED;
		}
	}

	public void mOnClick(View v){
		switch(v.getId()){
		case R.id.sdTest:
			String rootdir = Environment.getRootDirectory().getAbsolutePath();
			String datadir = Environment.getDataDirectory().getAbsolutePath();
			String cachedir = Environment.getDownloadCacheDirectory().getAbsolutePath();
			mEdit.setText(String.format("ext = %s\nroot=%s\ndata=%s\ncache=%s", mSdPath, rootdir, datadir, cachedir));
			break;
			
		case R.id.sdSave:
			File dir = new File(mSdPath + "/dir");
			dir.mkdir();
			File file = new File(mSdPath + "/dir/file.txt");
			try {
				FileOutputStream fos = new FileOutputStream(file);
				String str = mEdit.getText().toString();
				fos.write(str.getBytes());
				fos.close();
				mEdit.setText("write success");
			} catch (FileNotFoundException e) {
				mEdit.setText("File Not Found." + e.getMessage());
			} catch (SecurityException e) {
				mEdit.setText("Security Exception");
			} catch (Exception e){
				mEdit.setText(e.getMessage());
			}
			break;
			
		case R.id.sdLoad:
			try{
				FileInputStream fis = new FileInputStream(mSdPath + "/dir/file.txt");
				byte[] data = new byte[fis.available()];
				fis.read(data);
				fis.close();
				mEdit.setText(new String(data));
			}catch(FileNotFoundException e){
				mEdit.setText("File Not Found");
			}catch(Exception e){
				;
			}
			break;
		}
	}
}
