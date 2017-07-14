package com.ks.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
//    MyBoundService mBoundService;
//    boolean mBound;
    boolean runService = false;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent();
        intent.setClass(this,MyService.class);
        Button startBtn = (Button) findViewById(R.id.startBtn);
        Button stopBtn = (Button) findViewById(R.id.stopBtn);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runService = true;
                startService(intent);
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runService = false;
                stopService(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (runService){
            startService(intent);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (runService){
            stopService(intent);
        }
    }
}