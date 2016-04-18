package kr.hkit.android_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class BroadCastReceiverEx extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Uri uri = Uri.parse("http://www.google.co.kr");
		Intent intent1 = new Intent(Intent.ACTION_VIEW);
		intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent1);
		
		Toast.makeText(context, intent.getStringExtra("TTTT"), 0).show();
	}

}
