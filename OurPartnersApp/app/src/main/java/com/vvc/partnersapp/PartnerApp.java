package com.vvc.partnersapp;

import android.app.Application;
import android.support.multidex.MultiDex;

public class PartnerApp extends Application {

    private static PartnerApp mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
        mApplication = this;
    }

    public static PartnerApp getApplicationInstance() {
        return mApplication;
    }
}
