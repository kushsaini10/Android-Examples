package com.ks.services;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    boolean runService = false;
    Intent intent;
    static final String SERVICE_STATE = "serviceState";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState!=null){
            runService = savedInstanceState.getBoolean(SERVICE_STATE);
        }
        intent = new Intent();
        intent.setClass(this,MyService.class);
        final Button startBtn = (Button) findViewById(R.id.startBtn);
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
        Button button = (Button) findViewById(R.id.btn_next_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setClass(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(SERVICE_STATE, runService);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (runService){
            startService(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
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