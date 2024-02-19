package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.javabean.User;

/**
 * TODO：利用数据库对登录进行控制
 * author：zwt
 * email：1987901354@qq.com
 * data：2024.2.16
 */
public class Mysqliteopenhelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "MYsqlit.db";

    private static final String create_users = "create table users(name varchar(32),password varchar(32))";

    public Mysqliteopenhelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create_users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //实现注册传参
    public long register(User u) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", u.getName());
        cv.put("password", u.getPassword());
        long users = db.insert("users", null, cv);
        return users;
    }

    //登陆判断
    public boolean login(String name, String password) {
        SQLiteDatabase db1 = getWritableDatabase();
        boolean result = false;
        Cursor users = db1.query("users", null, "name like ?", new String[]{name}, null, null, null);
        if (users != null) {
            while (users.moveToNext()) {
                String password1 = users.getString(1);
                result = password1.equals(password);
                return result;
            }
        }
        return false;
    }

}
