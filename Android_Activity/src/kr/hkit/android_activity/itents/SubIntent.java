package kr.hkit.android_activity.itents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import kr.hkit.android_activity.R;

public class SubIntent extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.subintent);
		
		Intent passedIntent = getIntent();
		if(passedIntent != null){
			//String loginName = passedIntent.getStringExtra("loginName");
			String loginName = User.loginName;
			Toast.makeText(this, "새로운 화면에서 받은 loginName" + loginName, Toast.LENGTH_SHORT).show();
		}

		findViewById(R.id.btn_intentBack).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(), "돌아가기 버튼이 눌렸어요.", Toast.LENGTH_SHORT).show();

				Intent intent = new Intent();
				intent.putExtra("name", "mike");

				setResult(User.RES_CODE_SUCCESS, intent);

				finish();
				
			}
		});
		
	}
}
