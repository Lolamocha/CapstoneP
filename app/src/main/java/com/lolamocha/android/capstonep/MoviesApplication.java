package com.lolamocha.android.capstonep;

import android.app.Application;

import timber.log.Timber;


public class MoviesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }
}
