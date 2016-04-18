package kr.hkit.android_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class FreeBR extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent loginIntent = new Intent(context, LoginEx.class);
		loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(loginIntent);
		
		String str = intent.getStringExtra("BroadCast");
		Toast.makeText(context, str, 0).show();
	}

}
