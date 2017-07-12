package com.ks.fragments;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ks.fragments.dummy.Frag_two;

public class MainActivity extends AppCompatActivity {
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText("This is in Activity");
        final android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        FragOne fragOne = new FragOne();
        fragmentTransaction.add(R.id.fragment_one_container,fragOne);
        fragmentTransaction.commit();
        Button button = (Button) findViewById(R.id.frag_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Frag_two frag_two = new Frag_two();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_one_container,frag_two);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}
