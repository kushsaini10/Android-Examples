package com.ks.fragments;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FragOne.OnTextChangedListenerFragOne,FragTwo.OnTextChangedListenerFragTwo {
    FragmentTransaction fragmentTransaction;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText("This is in Activity, so, will not change.");
        final android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        final Bundle bundle = new Bundle();
        bundle.putString(tv.getText()+"","text_from_activity");
        FragOne fragOne = new FragOne();
        fragOne.setArguments(bundle);
        fragmentTransaction.add(R.id.fragment_one_container,fragOne);
        fragmentTransaction.commit();
        button = (Button) findViewById(R.id.frag_btn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FragTwo frag_two = new FragTwo();
                frag_two.setArguments(bundle);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_one_container,frag_two);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                button.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        button.setVisibility(View.VISIBLE);
    }

    @Override
    public void TextChanged(String text) {
        TextView textView = (TextView) findViewById(R.id.tv);
        textView.setText(text);
    }
}
