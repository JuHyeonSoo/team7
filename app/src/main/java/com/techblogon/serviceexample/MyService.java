package com.techblogon.serviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service{

	private static final String TAG = "MyService";
	public Timer timer = new Timer();

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
		Toast.makeText(this, "서비스를 시작합니다!", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onCreate");
	}

	@Override
	public void onStart(Intent intent, int startId) {
		TimerTask adTast = new TimerTask() {
			public void run() {
				Log.d(TAG, "onStart");
			}
		};
		timer.schedule(adTast, 0, 5000); // 0초후 첫실행, 3초마다 계속실행
	}
	
	@Override
	public void onDestroy() {
		Toast.makeText(this, "서비스를 정지합니다!", Toast.LENGTH_LONG).show();
		Log.d(TAG, "onDestroy");
		timer.cancel();
		timer=null;
	}
}
