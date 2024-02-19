package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.javabean.Study_Adapter;

/**
 * TODO：对学习界面进行调控
 * author：zwt
 * email：1987901354@qq.com
 * data：2024.2.19
 */

public class StudyActivity extends AppCompatActivity {
    private RecyclerView MrvStudy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        MrvStudy = findViewById(R.id.mRv);
        //利用adapter显示item
        MrvStudy.setLayoutManager(new LinearLayoutManager(StudyActivity.this));
        //设置adapter
        MrvStudy.setAdapter(new Study_Adapter.LinearCourseFinishAdapter(StudyActivity.this, new Study_Adapter.LinearCourseFinishAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(StudyActivity.this, "click..." + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    //设置点击事件
    public void fanhui_study(View view) {
        Intent intent = new Intent(this, FunctionActivity.class);
        startActivity(intent);
    }
}