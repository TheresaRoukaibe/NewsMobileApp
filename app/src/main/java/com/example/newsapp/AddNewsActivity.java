package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;

public class AddNewsActivity extends AppCompatActivity {
    EditText location;
    EditText time;
    EditText desc;
    EditText title;
    String author;
    SharedPreferences sharedPreferences;
DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));
        location = findViewById(R.id.location);
        time = findViewById(R.id.time);
        desc = findViewById(R.id.description);
        title = findViewById(R.id.news_title);
        sharedPreferences = getSharedPreferences("com.lau.news", MODE_PRIVATE);
        author = sharedPreferences.getString("name", null);
      DB = new DBHelper(this);
    }

    public void addInfo(View v) {
        String loc_info = location.getText().toString();
        String time_info = time.getText().toString();
        String desc_info = desc.getText().toString();
        String title_info = title.getText().toString();

        if(loc_info.equalsIgnoreCase("") || time_info.equalsIgnoreCase("") || desc_info.equalsIgnoreCase("") || title_info.equalsIgnoreCase("")){
            Toast.makeText(AddNewsActivity.this, "Please provide all information mentioned", Toast.LENGTH_SHORT).show();
        }else{
            Boolean check = DB.insertNews(loc_info, time_info, desc_info, title_info);
            if(check){
                Toast.makeText(AddNewsActivity.this, "Your news was added!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddNewsActivity.this, BrowseActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(AddNewsActivity.this, "Something went wrong while trying to insert your news", Toast.LENGTH_SHORT).show();
            }
        }

    }
}