package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class getNewsDetails extends AppCompatActivity {

    DBHelper DB;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_news_details);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));
        DB = new DBHelper(this);
        Intent i = getIntent();
        String title = "Bank Raid";
        Toast.makeText(this, title, Toast.LENGTH_LONG).show();
        textView = findViewById(R.id.location_text);
        Cursor c = DB.getSingleNews(title);
        int idx = c.getColumnIndex("location_name");
        c.moveToFirst();
        String loc = "";
        if (c.getCount() > 0) {
            if(c != null) {
                loc = c.getString(idx);

            }
            textView.setText("Location: " + loc);
        } else {
            textView.setText("Error");
        }

    }
}
