package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class ExpendActivity extends AppCompatActivity {
    private TextView tvWeather, tvWin, tvWinLevel, tvTemLow, tvTemHigh;
    private TextView tvContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expend);
        tvContext = findViewById(R.id.Mtry);
        tvWeather = findViewById(R.id.weather);
        tvWin = findViewById(R.id.where);
        tvTemHigh = findViewById(R.id.Max_tem);
        tvTemLow = findViewById(R.id.Min_tem);
        tvWinLevel = findViewById(R.id.wind_power);
    }

    public void fanhui_expend(View view) {
        Intent intent = new Intent(this, FunctionActivity.class);
        startActivity(intent);
    }

    public void parseJsonDataAndShow(String jsonStr) {

        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            String cityId = jsonObject.optString("cityid");
            String city = jsonObject.optString("city");
            String updateTime = jsonObject.optString("update_time");
            String weather = jsonObject.optString("wea");
            String weatherImg = jsonObject.optString("wea_img");
            String tem = jsonObject.optString("tem");
            String wemDay = jsonObject.optString("tem_day");
            String weNight = jsonObject.optString("tem_night");
            String win = jsonObject.optString("win");
            String winSpeed = jsonObject.optString("win_speed");
            String winMeter = jsonObject.optString("win_meter");
            String air = jsonObject.optString("air");

            // 显示json数据

            tvWeather.setText(weather);
            tvWin.setText(win);
            tvWinLevel.setText(winSpeed);
            tvTemLow.setText(weNight);
            tvTemHigh.setText(wemDay);


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
    //设置主线程

    private Handler mHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String strData = (String) msg.obj;
                tvContext.setText(strData);
                parseJsonDataAndShow(strData);

                Toast.makeText(ExpendActivity.this, "主线程收到来自网络的消息了", Toast.LENGTH_SHORT).show();
            }
        }
    };

    //子线程
    public void start(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String stringFromNet = getStringFromNet();
                Message message = new Message();
                message.what = 0;
                message.obj = stringFromNet;

                mHandler.sendMessage(message);
            }
        }).start();

        Toast.makeText(this, "开启子线程请求网络", Toast.LENGTH_SHORT).show();
    }

    //设置城市
    public String getStringFromNet() {
        return NetUtil.getWeatherOfCity("重庆");
    }

}
