package com.ks.schedulingnotifications;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ComponentName componentName = new ComponentName(this, MyJobService.class);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            JobInfo.Builder jobBuilder = new JobInfo.Builder(1, componentName);
            String myDate = "2017/09/8 12:33:00";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = null;
            try {
                date = sdf.parse(myDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            long millis = date.getTime();
            Log.e("Date Time", "" + millis);
            Log.e("Current Time", "" + System.currentTimeMillis());
            Long scheduleTime = date.getTime() - System.currentTimeMillis();
            jobBuilder.setMinimumLatency(scheduleTime);
            jobBuilder.setPersisted(true);
            Log.e("Scheduled Time", "" + scheduleTime);
            JobScheduler tm = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
            tm.schedule(jobBuilder.build());
        }else {

//            String myDate = "2017/09/9 03:25:00";
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//            Date date = null;
//            try {
//                date = sdf.parse(myDate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            long millis = date.getTime();
//            Log.e("Date Time", "" + millis);
            Log.e("Current Time", "" + System.currentTimeMillis());
//            Long scheduleTime = date.getTime() - System.currentTimeMillis();
            Calendar myAlarmDate = Calendar.getInstance();
            myAlarmDate.setTimeInMillis(System.currentTimeMillis());
            myAlarmDate.set(2017, 8, 8, 17, 40, 0);


            Calendar c = Calendar.getInstance();
            c.add(Calendar.SECOND, 10);
            long firstTime = c.getTimeInMillis();

            PendingIntent mAlarmSender = PendingIntent.getBroadcast(this, 0, new Intent(this, AlarmReceiver.class), 0);
            AlarmManager am = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
            am.set(AlarmManager.RTC_WAKEUP, myAlarmDate.getTimeInMillis(), mAlarmSender);
//            jobBuilder.setMinimumLatency(scheduleTime);
            Log.e("Scheduled Time", "Alarm will trigger on : " + myAlarmDate.getTimeInMillis());
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            NotificationBuilder.makeNotification(this);
//
//            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
////            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
        }
    }
}
