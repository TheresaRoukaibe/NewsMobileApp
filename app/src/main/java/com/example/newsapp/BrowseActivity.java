package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BrowseActivity extends AppCompatActivity {
TextView textView;
SharedPreferences sharedPreferences;
private static final String key_name = "name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));
        textView = findViewById(R.id.welcome);
        sharedPreferences = getSharedPreferences("com.lau.news", MODE_PRIVATE);
        String name = sharedPreferences.getString(key_name, null);
        if(name!= null){
            textView.setText("Hi ! " + name);
        }

    }

    public void goToAct(View v){
        Intent intent = new Intent(BrowseActivity.this, AddNewsActivity.class);
        startActivity(intent);
    }

}