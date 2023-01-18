package com.mimtiaze.android.training.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public final static String TAG = "Service";

    Toast mToast;
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
        mToast = Toast.makeText(this, "Service created", Toast.LENGTH_SHORT);
        mToast.show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        mToast = Toast.makeText(this, "Service started", Toast.LENGTH_SHORT);
        mToast.show();
        return super.onStartCommand(intent, flags, startId);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
        mToast = Toast.makeText(this, "Service destroyed", Toast.LENGTH_SHORT);
        mToast.show();
    }
}