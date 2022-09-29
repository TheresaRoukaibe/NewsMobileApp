package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;

import java.util.ArrayList;

public class AddNewsActivity extends AppCompatActivity {
    EditText location;
    EditText time;
    EditText desc;
    String author;
    SharedPreferences sharedPreferences;
    SharedPreferences news;
    ArrayList<String> infos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));
        location = findViewById(R.id.location);
        time = findViewById(R.id.time);
        desc = findViewById(R.id.description);
        sharedPreferences = getSharedPreferences("com.lau.news", MODE_PRIVATE);
        author = sharedPreferences.getString("name", null);
        news = getSharedPreferences("com.lau.db", MODE_PRIVATE);
    }

    public void addInfo(View v) {
        
    }
}