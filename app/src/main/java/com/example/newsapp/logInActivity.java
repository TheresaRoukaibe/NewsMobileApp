package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class logInActivity extends AppCompatActivity {
EditText editText;
SharedPreferences sharedPreferences;
private static final String key_name = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.teal_700)));
        editText = findViewById(R.id.username);
        sharedPreferences = getSharedPreferences("com.lau.news", Context.MODE_PRIVATE);
    }

    public void sendInfo(View v) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String username_text = editText.getText().toString();
        if (username_text.equalsIgnoreCase("")) {
            Toast.makeText(logInActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
        } else {


            editor.putString(key_name, editText.getText().toString());
            editor.apply();
            Intent intent = new Intent(logInActivity.this, BrowseActivity.class);
            startActivity(intent);
            Toast.makeText(logInActivity.this, "Logging in", Toast.LENGTH_SHORT).show();
        }
    }
}