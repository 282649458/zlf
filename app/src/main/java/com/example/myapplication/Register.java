package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.javabean.User;

/**
 * TODO：成功注册
 * author：zwt
 * email：1987901354@qq.com
 * data：2024.2.16
 */
public class Register extends AppCompatActivity {
    private Button mBtnregister1;
    private EditText mEdtUser1;
    private EditText mEdtKey1;
    private Mysqliteopenhelper mysqliteopenhelper1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEdtUser1 = findViewById(R.id.mUser1);
        mEdtKey1 = findViewById(R.id.mKey1);
        mBtnregister1 = findViewById(R.id.btn_register1);
        mysqliteopenhelper1 = new Mysqliteopenhelper(this);

    }

    //注册实现
    public void mRegister(View view) {
        String user1 = mEdtUser1.getText().toString();
        String user2 = mBtnregister1.getText().toString();
        User u = new User(user1, user2);
        long l = mysqliteopenhelper1.register(u);
        if (l != -1) {
            Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
            Intent i3 = new Intent(this, MainActivity.class);
            startActivity(i3);
        } else {
            Toast.makeText(this, "注册失败！", Toast.LENGTH_SHORT).show();
        }
    }

    //回到登陆界面
    public void fanhui_main(View view) {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}