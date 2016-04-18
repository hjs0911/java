package kr.hkit.android_activity.files;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import kr.hkit.android_activity.R;

public class MyFileEx01 extends Activity {
	EditText fileName, fileEdit;
	String sdcardPath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myfile01ex);

		fileName = (EditText) findViewById(R.id.et_MyFileName);
		fileEdit = (EditText) findViewById(R.id.et_MyFileEdit);

		File sdcardFolder = Environment.getExternalStorageDirectory();
		sdcardPath = sdcardFolder.getAbsolutePath();
	}

	public void mOnClick(View v) {
		String filename = fileName.getText().toString();
		filename = sdcardPath + File.separator + filename;

		switch (v.getId()) {
		case R.id.btn_MyFile_Write:
			String contents = fileEdit.getText().toString();

			writeToFile(filename, contents);
			Toast.makeText(getApplicationContext(), "파일생성", Toast.LENGTH_SHORT).show();
			break;
		case R.id.btn_MyFile_Read:
			fileEdit.setText(readFromFile(filename));
			break;
		}
	}

	private String readFromFile(String filename) {
		File file = new File(filename);

		String output = null;
		int count = 0;
		byte[] data = new byte[1024];
		try {
			FileInputStream instream = new FileInputStream(file);
			DataInputStream reader = new DataInputStream(instream);

			StringBuffer strBuf = new StringBuffer();
			/* String line = ""; 
			
			 while (line != null) { line = reader.readLine();
			 strBuf.append(line + "\n"); }*/
			 

			
			
			while (count > -1) {
				count = reader.read(data, 0, 1024);

				String line = new String(data, 0, count, "UTF-8");
				if (count > 0) {
					if (line != null) {
						strBuf.append(line);
					}
				}
				new Thread(){

					@Override
					public void run() {
						try {
							sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				};
				Toast.makeText(getApplicationContext(), "count : "+count+" data : "+data.length, 0).show();
			}
			output = strBuf.toString();

			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e){
			Toast.makeText(getApplicationContext(), "count : "+count+" data : "+data.length, 0).show();
		}
		return output;
	}

	private void writeToFile(String filename, String contents) {
		File file = new File(filename);

		try {
			FileOutputStream fileStream = new FileOutputStream(file);
			DataOutputStream outStraem = new DataOutputStream(fileStream);

			outStraem.writeUTF(contents);
			outStraem.flush();
			outStraem.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
