package com.example.root.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    MyAdapter adapter;
    ArrayList<String> data;
    RecyclerView recyclerView;
    public static int add(int a, int b){
        return a+b;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = new ArrayList<>();
        for(int i=1;i<=10;i++){
            data.add("Item "+i);
        }
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new MyAdapter(data,this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.size()>0) {
                    data.remove(data.size() - 1);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
