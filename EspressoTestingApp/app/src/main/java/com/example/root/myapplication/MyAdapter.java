package com.example.root.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by root on 18/7/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv1;
        TextView tv2;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.tv_1);
//            tv2 = (TextView) itemView.findViewById(R.id.tv_2);
        }
    }
    Context mContext;
    ArrayList<String> dataListOne;

    public MyAdapter(ArrayList<String> dataListOne, Context mContext) {
        this.dataListOne = dataListOne;
        this.mContext = mContext;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String text = dataListOne.get(position);
        holder.tv1.setText(text);
    }

    @Override
    public int getItemCount() {
        return dataListOne.size();
    }
}
