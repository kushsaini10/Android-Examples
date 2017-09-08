package com.ks.schedulingnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.NotificationCompat;

/**
 * Created by ks on 7/9/17.
 */

public class NotificationBuilder {
    public static void makeNotification(Context context){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("Title");
        builder.setContentText("Content");
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setSmallIcon(R.mipmap.ic_launcher_round);
        builder.setCategory(NotificationCompat.CATEGORY_REMINDER);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);
        builder.setShowWhen(true);
        builder.setAutoCancel(true);
        builder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        builder.build();

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0,builder.build());
    }
}
