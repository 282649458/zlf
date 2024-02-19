package com.example.myapplication;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

/**
 * TODO：与网络数据链接
 * author：zwt
 * email：1987901354@qq.com
 * data：2024.2.18
 */
public class NetUtil {

    public static String Base_URL = "http://v1.yiketianqi.com/free/day";
    public static String App_ID = "67896285";
    public static String App_secret = "gAKt5H70";

    public static String doGet(String url) {
        BufferedReader reader = null;
        String bookJSONString = null;
        HttpURLConnection httpURLConnection = null;
        try {
            //  建立连接

            URL requestUrl = new URL(url);
            httpURLConnection = (HttpURLConnection) requestUrl.openConnection();
            httpURLConnection.setRequestProperty("Charset", "utf-8");
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);

            httpURLConnection.connect();

            //  获取二进制流
            InputStream inputStream = httpURLConnection.getInputStream();
            //  将二进制流包装
            reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            //  从BufferedReader中读取string字符串
            String line;
            StringBuilder builder = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }

            if (builder.length() == 0) {
                return null;
            }

            bookJSONString = builder.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // StringBuilder拼接成最终的字符串文本

        finally {
            // 关闭连接
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return bookJSONString;
    }


    public static String getWeatherOfCity(String kind) {
        //拼接get的请求url
        String WeatherUrl = Base_URL + "?appid=" + App_ID + "&appsecret=" + App_secret + "&city=" + kind;
        Log.d("fan", "----NewsUrl----" + WeatherUrl);
        String NewsResult = doGet(WeatherUrl);


        return decodeUnicode(NewsResult);
    }

    //换字符，
    public static String decodeUnicode(String unicodeStr) {
        if (unicodeStr == null) {
            return null;
        }
        StringBuffer retBuf = new StringBuffer();
        int maxLoop = unicodeStr.length();
        for (int i = 0; i < maxLoop; i++) {
            if (unicodeStr.charAt(i) == '\\') {
                if ((i < maxLoop - 5) && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr.charAt(i + 1) == 'U')))
                    try {
                        retBuf.append((char) Integer.parseInt(unicodeStr.substring(i + 2, i + 6), 16));
                        i += 5;
                    } catch (NumberFormatException localNumberFormatException) {
                        retBuf.append(unicodeStr.charAt(i));
                    }
                else
                    retBuf.append(unicodeStr.charAt(i));
            } else {
                retBuf.append(unicodeStr.charAt(i));
            }
        }
        return retBuf.toString();
    }
}
