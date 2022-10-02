package com.example.newsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("CREATE Table IF NOT EXISTS news_data (location_name VARCHAR(255), time_name VARCHAR(255), desc_name VARCHAR(255), title_name VARCHAR(255))");
    }

    public DBHelper(Context context) {
        super(context, "news_db", null, 1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists news_data");
    }

    public boolean insertNews(String location_name, String time_name, String desc_name, String title_name){

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues ct = new ContentValues();
        ct.put("location_name", location_name);
        ct.put("time_name", time_name);
        ct.put("desc_name", desc_name);
        ct.put("title_name", title_name);
        long result = DB.insert("news_data", null, ct);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getSingleNews(String t){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor c = DB.rawQuery("Select location_name FROM news_data WHERE title_name=?",new String[] {t}, null);
        return c;
    }
    public Cursor getNews(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor c = DB.rawQuery("Select * FROM news_data", null);
        return c;
    }

   }





