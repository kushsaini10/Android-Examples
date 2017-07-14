package com.ks.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by ks on 14/7/17.
 */

public class MyBoundService extends Service {
    private final IBinder mBinder = new LocalBinder();
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this,"Binding",Toast.LENGTH_SHORT);
        return mBinder;
    }

    private class LocalBinder extends Binder {
        MyBoundService getService(){
            return MyBoundService.this;
        }
    }
}
