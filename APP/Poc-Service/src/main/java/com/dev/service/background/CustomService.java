package com.dev.service.background;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomService extends Service {
    private static final List<String> ALLOW_WHITE_LIST = new ArrayList<>(List.of("com.android.settings"));

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class IncomingHandler extends Handler {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    }

    private boolean callerCanAccess() {
        int callingUid = Binder.getCallingUid();
        String name = getPackageManager().getNameForUid(callingUid);

        return !TextUtils.isEmpty(name) && ALLOW_WHITE_LIST.contains(name);
    }
}
