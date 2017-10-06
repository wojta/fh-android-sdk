package com.feedhenry.sync;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created on 10/5/17.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
