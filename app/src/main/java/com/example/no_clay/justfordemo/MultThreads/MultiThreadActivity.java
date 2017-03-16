package com.example.no_clay.justfordemo.MultThreads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.no_clay.justfordemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MultiThreadActivity extends AppCompatActivity {

    @BindView(R.id.intentService)
    Button mIntentService;
    @BindView(R.id.handlerThread)
    Button mHandlerThread;
    @BindView(R.id.AsyncTask)
    Button mAsyncTask;
    @BindView(R.id.activity_multi_thread)
    LinearLayout mActivityMultiThread;

    MyAsncTask mMyAsncTask;
    Handler mHandler;
    @BindView(R.id.show)
    TextView mShow;

    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_thread);
        ButterKnife.bind(this);
        HandlerThread thread = new HandlerThread("测试");
        thread.start();
        mHandler = new Handler(thread.getLooper()) {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Log.d("handler", "handleMessage: what = " + msg.what);
                Log.d("handler", "handleMessage: thread = " +
                        Thread.currentThread().getName());

                mShow.setText("测试" + msg.what);
            }
        };
        if (mHandler != null && mHandler.getLooper() != null) {
            mHandler.sendEmptyMessage(1);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (mHandler != null && mHandler.getLooper() != null) {
                    mHandler.sendEmptyMessage(2);
                }
            }
        }).start();
    }

    @OnClick({R.id.intentService, R.id.handlerThread, R.id.AsyncTask})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.intentService:
                Intent intent = new Intent(mContext, MyIntentService.class);
                startService(intent);
                break;
            case R.id.handlerThread:
                break;
            case R.id.AsyncTask:
                mMyAsncTask = new MyAsncTask(mContext);
                mMyAsncTask.execute(100);
                break;
        }
    }
}
