package com.example.no_clay.justfordemo.MultThreads;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by no_clay on 2017/3/15.
 */

public class MyAsncTask extends AsyncTask<Integer, Integer, String>{

    private Context mContext;
    private static final String TAG = "MyAsncTask";

    public MyAsncTask(Context context) {
        mContext = context;
    }

    @Override
    protected String doInBackground(Integer... params) {
        Log.d(TAG, "doInBackground: 此处是 = " + Thread.currentThread().getName());
        for (int i = 0; i < params[0]; i++) {
            Log.d(TAG, "doInBackground: excute = " + i);
            publishProgress(12);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "运行结束";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.d(TAG, "onProgressUpdate: 此处是 = " + Thread.currentThread().getName());
        super.onProgressUpdate(values);
        Log.d(TAG, "onProgressUpdate: values = " + (values ));
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d(TAG, "onPreExecute: 此处是 = " + Thread.currentThread().getName());
    }

    @Override
    protected void onPostExecute(String s) {
        Log.d(TAG, "onPostExecute: s = " + s);
        Log.d(TAG, "onPostExecute: 此处是 = " + Thread.currentThread().getName());
        super.onPostExecute(s);
    }
}
