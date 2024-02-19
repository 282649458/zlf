package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * TODO：实现返回功能
 * author：zwt
 * email：1987901354@qq.com
 * data：2024.2.16
 */

public class NovelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);
    }

    //返回主界面
    public void fanhui_novel(View view) {
        Intent intent = new Intent(this, FunctionActivity.class);
        startActivity(intent);
    }
}