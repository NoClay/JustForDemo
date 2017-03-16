package com.example.no_clay.justfordemo.MultThreads;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by no_clay on 2017/3/15.
 */

public class MyIntentService extends IntentService{

    private static final String TAG = "MyIntentService";


    public MyIntentService() {
        // 必须定义一个无参数的构造方法，并调用super(name)进行初始化，否则出错。
        super("CoreService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: start");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (int i = 0; i < 10; i++) {
            try {
                Log.d(TAG, "onHandleIntent: execute = " + i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "onHandleIntent: sleep over");
        }

    }


}
