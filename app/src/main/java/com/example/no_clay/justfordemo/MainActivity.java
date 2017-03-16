package com.example.no_clay.justfordemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.no_clay.justfordemo.MultThreads.MultiThreadActivity;
import com.example.no_clay.justfordemo.Util.Adapter;
import com.example.no_clay.justfordemo.Util.Demo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.demoList)
    RecyclerView mDemoList;

    Adapter mAdapter;
    List<Demo> mDemos;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDemoDatas();

    }

    private void initDemoDatas() {
        addDemo("测试android多线程", MultiThreadActivity.class);
        mAdapter = new Adapter(context, mDemos);
        mDemoList.setAdapter(mAdapter);
        mDemoList.setLayoutManager(new LinearLayoutManager(context));
    }

    private void addDemo(String title, Class demoClass){
        if (mDemos == null){
            mDemos = new ArrayList<>();
        }
        Demo demo = new Demo(new Intent(context, demoClass), title);
        mDemos.add(demo);
    }
}
