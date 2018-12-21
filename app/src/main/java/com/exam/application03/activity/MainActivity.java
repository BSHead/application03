package com.exam.application03.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.exam.application03.R;
import com.exam.application03.bean.Page;
import com.exam.application03.core.BasePage;
import com.exam.application03.present.MyPresent;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BasePage,OnBannerListener{

    private Banner banner;
    private MyPresent myPresent;
    private List<Page > list = new ArrayList<>();
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = findViewById(R.id.main_banner);
        myPresent = new MyPresent((BasePage) this);
        button = findViewById(R.id.mybut);
        myPresent.getCarData();

    }


    @Override
    public void successpage(List<Page> pages) {

        Toast.makeText(this, pages.size() + "", Toast.LENGTH_SHORT).show();

        ArrayList<String> listu = new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            listu.add(pages.get(i).getIcon());
        }
        ArrayList<String> list_title = new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            listu.add(pages.get(i).getTitle());
        }
        banner.setImages(listu);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load((String) path).into(imageView);
            }
        });
        banner.setBannerTitles(list_title);
        banner.isAutoPlay(false);
        banner.setOnBannerListener(this);
        banner.start();
    }

    @Override
    public void OnBannerClick(int position) {
        //Toast.makeText(this, "点击了+", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
    }
}