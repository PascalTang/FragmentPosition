package com.android.pascal.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

class MyAdapter extends RecyclerView.Adapter {
    private String[] mDataset ;
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder vh = (MyViewHolder)holder;
        vh.mTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTextView;
        public MyViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }
}
