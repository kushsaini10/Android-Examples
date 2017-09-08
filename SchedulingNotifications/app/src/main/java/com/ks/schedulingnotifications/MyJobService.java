package com.ks.schedulingnotifications;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.support.annotation.RequiresApi;
import android.util.Log;

/**
 * Created by ks on 7/9/17.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MyJobService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Log.w("Job Service", "Running");
        NotificationBuilder.makeNotification(this);
//        Intent intent = new Intent(this, Main2Activity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_ANIMATION | Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_FROM_BACKGROUND);
//        startActivity(intent);
        PowerManager pm = (PowerManager) getApplicationContext().getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wakeLock = pm.newWakeLock((PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP), "MY_NOTIFICATION");
        wakeLock.acquire();
        wakeLock.release();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        Log.w("Job Service", "Stopped");
        return false;
    }
}
