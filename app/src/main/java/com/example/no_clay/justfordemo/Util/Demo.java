package com.example.no_clay.justfordemo.Util;

import android.content.Intent;

/**
 * Created by no_clay on 2017/3/15.
 */

public class Demo {
    private Intent mIntent;
    private String title;

    public Demo(Intent intent, String title) {
        mIntent = intent;
        this.title = title;
    }

    public Intent getIntent() {
        return mIntent;
    }

    public void setIntent(Intent intent) {
        mIntent = intent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
