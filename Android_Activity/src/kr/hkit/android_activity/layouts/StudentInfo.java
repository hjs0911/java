package kr.hkit.android_activity.layouts;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import kr.hkit.android_activity.R;

public class StudentInfo extends Activity {
	private ImageView image;
	private EditText etName, etAge;
	private String imagePath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studinfo);

		image = (ImageView) findViewById(R.id.imageFrog);
		image.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(intent, 1);
			}
		});
		etName = (EditText) findViewById(R.id.Info_etName);
		etAge = (EditText) findViewById(R.id.Info_etAge);

		Intent intent = getIntent();
		try {
			if (intent != null) {
				Student s = (Student) intent.getSerializableExtra("profile");
				etName.setText(s.getName());
				etAge.setText(s.getAge()+"");
				image.setImageBitmap(BitmapFactory.decodeFile(s.getImgPath()));
			}
		} catch (NullPointerException e) {

		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
			Uri imageUri = data.getData();

			String[] filePathColumn = { MediaStore.Images.Media.DATA };
			Cursor cursor = getContentResolver().query(imageUri, filePathColumn, null, null, null);
			cursor.moveToFirst();
			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			imagePath = cursor.getString(columnIndex);
			image.setImageBitmap(BitmapFactory.decodeFile(imagePath));
		}
	}

	public void mOnClick(View v) {
		switch (v.getId()) {
		case R.id.Info_btnSave:
			Student stud = new Student();
			stud.setName(etName.getText().toString());
			stud.setAge(Integer.valueOf(etAge.getText().toString()));
			stud.setImgPath(imagePath);

			Intent data = new Intent();
			data.putExtra("profile", stud);
			setResult(RESULT_OK, data);
			finish();
			break;
		case R.id.Info_btnClose:
			finish();
			break;
		}
	}
}
