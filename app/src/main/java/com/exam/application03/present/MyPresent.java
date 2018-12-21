package com.exam.application03.present;

import android.os.AsyncTask;
import android.util.Log;

import com.exam.application03.bean.Car;
import com.exam.application03.bean.CarData;
import com.exam.application03.bean.Goods;
import com.exam.application03.bean.GoogsBean;
import com.exam.application03.bean.Page;
import com.exam.application03.bean.PageData;
import com.exam.application03.core.BaseCar;
import com.exam.application03.core.BaseGoods;
import com.exam.application03.core.BasePage;
import com.exam.application03.model.MyModel;
import com.google.gson.Gson;

import java.util.List;

public class MyPresent {
    private BasePage basePage;
    private BaseCar baseCar;


    public MyPresent(BaseCar baseCar) {
        this.baseCar = baseCar;
    }

    public MyPresent(BasePage basePage) {
        this.basePage = basePage;
    }

    public void getCarData(){

        String Strurl = "http://www.zhaoapi.cn/ad/getAd";

        new MyAsyncTask1().execute(Strurl);
    }
    class MyAsyncTask1 extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
            String dataJaon = MyModel.getPage(strings[0]);
            return dataJaon;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            PageData pageData = gson.fromJson(s, PageData.class);
            List<Page> data = pageData.getData();

            basePage.successpage(data);
        }
    }

    public void getCar(){

        String Strurl = "http://www.zhaoapi.cn/product/searchProducts?keywords=笔记本";

        new MyAsyncTaskcar().execute(Strurl);
    }
    class MyAsyncTaskcar extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
            String car = MyModel.getCar(strings[0]);
            return car;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            CarData carData = gson.fromJson(s, CarData.class);
            List<Car> data = carData.getData();
            baseCar.successpage(data);
        }
    }










    public void getGoods(){

        String Strurl = "http://www.zhaoapi.cn/product/getCatagory";

        new MyAsyncTaskgoods().execute(Strurl);
    }
    class MyAsyncTaskgoods extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... strings) {
            String goods = MyModel.getGoods(strings[0]);
            return goods;
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            GoogsBean googsBean = gson.fromJson(s, GoogsBean.class);
            List<Goods> data = googsBean.getData();
            Log.e("LL",data.size()+"");
            baseCar.successpgoods(data);
        }
    }

}
