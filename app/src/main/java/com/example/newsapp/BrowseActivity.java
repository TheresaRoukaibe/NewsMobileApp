package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BrowseActivity extends AppCompatActivity {
TextView textView;
SharedPreferences sharedPreferences;
    SQLiteDatabase db;
    RecyclerView my_list;
  ArrayList<String> title;
    ArrayList<String> time;
    ArrayList<String> desc;
    ArrayList<String> loc;
  DBHelper DB;
  myAdapter adapter;

private static final String key_name = "name";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));
        textView = findViewById(R.id.welcome);
        my_list = (RecyclerView) findViewById(R.id.mylist);
        sharedPreferences = getSharedPreferences("com.lau.news", MODE_PRIVATE);
        String name = sharedPreferences.getString(key_name, null);
        if(name!= null){
            textView.setText("Hi ! " + name + ", here are our news today: ");
        }
        DB = new DBHelper(this);
        title = new ArrayList<>();
        time = new ArrayList<>();
        desc = new ArrayList<>();
        loc = new ArrayList<>();
        adapter = new myAdapter(this, title, loc, time, desc);
        my_list.setAdapter(adapter);
        my_list.setLayoutManager(new LinearLayoutManager(this));
        display();
    }

    private void display() {
        Cursor c = DB.getNews();
        if(c.getCount() == 0){
            Toast.makeText(BrowseActivity.this, "No news yet", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while(c.moveToNext()){
                title.add(c.getString(3));
                loc.add(c.getString(0));
                time.add(c.getString(1));
                desc.add(c.getString(2));
            }
        }

    }

    public void goToAct(View v){
        Intent intent = new Intent(BrowseActivity.this, AddNewsActivity.class);
        startActivity(intent);
    }

}