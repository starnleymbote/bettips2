package com.nanocomputing.bettips;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

public class BettipsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Sample AdMob app ID: ca-app-pub-3940256099942544~3347511713
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
    }
}
