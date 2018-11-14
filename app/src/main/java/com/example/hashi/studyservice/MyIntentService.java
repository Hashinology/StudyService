package com.example.hashi.studyservice;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;


public class MyIntentService extends Service{
    private static final String TAG = MyIntentService.class.getSimpleName();

    public MyIntentService() {
        super("MyWorkerThread");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate, Thread name: " + Thread.currentThread().getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "onHandleIntent, Thread name: " + Thread.currentThread().getName());

        int sleepTime = intent.getIntExtra("sleepTime", 1);

        int ctr = 1;

        // Dummy Long Operation
        while(ctr <= sleepTime) {
            Log.i(TAG, "Counter is now " + ctr);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ctr++;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy, Thread name: " + Thread.currentThread().getName());
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
