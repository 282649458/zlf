package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * TODO：对功能界面控件实现功能
 * author：zwt
 * email：1987901354@qq.com
 * data：2024.2.16
 */
public class FunctionActivity extends AppCompatActivity {
    private ImageView mIvslide;
    private Slidemenu slidemenu;
    private android.widget.Button mBtnStudy;
    private android.widget.Button mBtnExpend;
    private android.widget.Button mBtNovel;
    private TextView tvContext;


    public FunctionActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fouction);

        //实例化//
        mIvslide = findViewById(R.id.main_headshot);
        slidemenu = findViewById(R.id.Mslide);
        mBtnStudy = findViewById(R.id.main_study);
        mBtnExpend = findViewById(R.id.main_expend);
        mBtNovel = findViewById(R.id.main_novel);
        mBtnExpend = findViewById(R.id.main_expend);
        //实现侧滑//
        mIvslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidemenu.switchMenu();
            }
        });
        Setlisener();

    }

    private void Setlisener() {

        Onclick onclick = new Onclick();
        mBtnStudy.setOnClickListener(onclick);
        mBtNovel.setOnClickListener(onclick);
        mBtnExpend.setOnClickListener(onclick);
    }


    private class Onclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            if (v.getId() == R.id.main_study) {
                intent = new Intent(FunctionActivity.this, StudyActivity.class);
            } else if (v.getId() == R.id.main_novel) {
                intent = new Intent(FunctionActivity.this, NovelActivity.class);
            } else if (v.getId() == R.id.main_expend) {
                intent = new Intent(FunctionActivity.this, ExpendActivity.class);
            }

            startActivity(intent);
        }
    }

    public void back_main(View view) {
        Intent intent4 = new Intent(this, MainActivity.class);
        startActivity(intent4);
    }
}