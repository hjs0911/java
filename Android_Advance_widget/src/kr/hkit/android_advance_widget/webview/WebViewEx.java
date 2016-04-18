package kr.hkit.android_advance_widget.webview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import kr.hkit.android_advance_widget.R;

public class WebViewEx extends Activity {
	WebView mWeb;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webviewex);
		
		mWeb = (WebView) findViewById(R.id.web);
		mWeb.setWebViewClient(new MyWebClient());
		WebSettings set = mWeb.getSettings();
		set.setJavaScriptEnabled(true);
		set.setBuiltInZoomControls(true);
		mWeb.loadUrl("http://www.naver.com");
	}
	
	public void mOnClick(View v){
		switch(v.getId()){
		case R.id.btn_go:
			EditText addr = (EditText) findViewById(R.id.address);
			String url = addr.getText().toString().trim();
			mWeb.loadUrl(url);
			break;
		case R.id.btn_back:
			if(mWeb.canGoBack())
				mWeb.goBack();
			break;
		case R.id.btn_forward:
			if(mWeb.canGoForward())
				mWeb.goForward();
			break;
		case R.id.btn_local:
			mWeb.loadUrl("file:///android_asset/test.html");
			break;
		}
	}
}

class MyWebClient extends WebViewClient{
	public boolean shouldOverrideUrlLoading(WebView view, String url){
		view.loadUrl(url);
		return true;
	}
}
