package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder>{
    private Context context;
    private ArrayList location_name, time_name, desc_name, title_name;

    public myAdapter(Context context, ArrayList title_name) {
        this.context = context;
        this.title_name = title_name;
    }

    public myAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.news_entry, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title_name.setText(String.valueOf(title_name.get(position)));

    }

    @Override
    public int getItemCount() {
        return title_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView location_name, time_name, desc_name, title_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title_name = itemView.findViewById(R.id.title);
        }
    }
}
