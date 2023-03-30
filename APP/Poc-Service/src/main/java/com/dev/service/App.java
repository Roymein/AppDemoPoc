package com.dev.service;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.util.Log;

public class App extends Application {
    public static final String TAG = "App";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        switch (level) {
            case TRIM_MEMORY_RUNNING_LOW:
                Log.i(TAG, "onTrimMemory: ");
                break;

            case TRIM_MEMORY_RUNNING_MODERATE:
                Log.d(TAG, "onTrimMemory: ");
                break;

            case TRIM_MEMORY_BACKGROUND:
                Log.i(TAG, "onTrimMemory: TRIM_MEMORY_BACKGROUND");
                break;

            case TRIM_MEMORY_COMPLETE:
                Log.i(TAG, "onTrimMemory:TRIM_MEMORY_COMPLETE ");
                break;

            case TRIM_MEMORY_MODERATE:
                Log.e(TAG, "onTrimMemory: ");
                break;

            case TRIM_MEMORY_RUNNING_CRITICAL:
                Log.i(TAG, "onTrimMemory: TRIM_MEMORY_RUNNING_CRITICAL");
                break;

            case TRIM_MEMORY_UI_HIDDEN:
                Log.i(TAG, "onTrimMemory: TRIM_MEMORY_UI_HIDDEN");
                break;

            default:
                break;
        }
    }
}
