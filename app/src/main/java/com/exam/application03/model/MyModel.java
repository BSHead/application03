package com.exam.application03.model;

import android.util.Log;

import com.exam.application03.utils.NetUtil;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyModel {
    public static String getPage(String strurl){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(strurl).get().build();
        try {
            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("LL","出现错误");
        }
        return "";
    }
    public static String getCar(String strurl){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(strurl).get().build();
        try {
            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("LL","出现错误");
        }
        return "";
    }
    public static String getGoods(String strurl){
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(strurl).get().build();
        try {
            Response response = okHttpClient.newCall(request).execute();

            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("LL","出现错误");
        }
        return "";
    }
}
