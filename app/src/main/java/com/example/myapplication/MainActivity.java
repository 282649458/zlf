package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.javabean.User;

/**
 * TODO：实现登录功能
 * * author：zwt
 *  * email：1987901354@qq.com
 *  * data：2024.2.16
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private android.widget.Button mBtnlogin;
    private Button mBtnregister;
    private EditText mEdtUser;
    private EditText mEdtKey;
    private Mysqliteopenhelper mysqliteopenhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mysqliteopenhelper = new Mysqliteopenhelper(this);


        mEdtUser = findViewById(R.id.mUser);
        mEdtKey = findViewById(R.id.mKey);
        mBtnlogin = findViewById(R.id.btn_login);
        mBtnregister = findViewById(R.id.btn_register);


        mBtnlogin.setOnClickListener(this);

        mBtnregister.setOnClickListener(this);

    }

    //登录功能实现
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_login) {
            String Id = mEdtUser.getText().toString();
            String Pd = mBtnregister.getText().toString();
            boolean login = mysqliteopenhelper.login(Id, Pd);
            if (login) {
                Intent intent1 = new Intent(this, FunctionActivity.class);
                Toast.makeText(this, "登陆成功！", Toast.LENGTH_SHORT).show();
                startActivity(intent1);
            } else {
                Toast.makeText(this, "登陆失败,请重新登录!", Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.btn_register) {
            Intent intent2 = new Intent(this, Register.class);
            startActivity(intent2);
        }
    }
}