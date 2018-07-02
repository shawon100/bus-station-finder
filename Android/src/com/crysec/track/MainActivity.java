package com.crysec.track;

import android.app.*;
import android.app.ActivityManager.*;
import android.content.*;
import android.os.*;
import android.webkit.*;
import java.util.*;
import android.view.SurfaceHolder.*;
import android.webkit.GeolocationPermissions.*;

class Client extends WebChromeClient
{

	@Override
	public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback)
	{
		callback.invoke(origin,true,false);
		super.onGeolocationPermissionsShowPrompt(origin, callback);
	}
}
public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		WebView wv=(WebView)findViewById(R.id.webView);
		wv.setWebChromeClient(new Client());
		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setGeolocationEnabled(true);
		wv.getSettings().setGeolocationDatabasePath(this.getFilesDir().getPath());
		wv.loadUrl("file:///android_asset/www/tracker.html");
		

	}
}
