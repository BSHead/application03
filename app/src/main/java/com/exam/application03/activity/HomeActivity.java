package com.exam.application03.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.exam.application03.R;
import com.exam.application03.adapter.MyAdapter;
import com.exam.application03.adapter.MyGridAdapter;
import com.exam.application03.bean.Car;
import com.exam.application03.bean.Goods;
import com.exam.application03.core.BaseCar;
import com.exam.application03.core.BaseGoods;
import com.exam.application03.core.OnItemClickListener;
import com.exam.application03.present.MyPresent;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements BaseCar,View.OnClickListener {

    private RecyclerView relativeLayout1,relativeLayout2;
    private MyPresent myPresent;
    private MyAdapter adapter;
    private LinearLayoutManager linerlayoutManager;
    private GridLayoutManager gridLayoutManager,gridLayoutManager111;
    private boolean isGrid = true;
    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        relativeLayout1 = findViewById(R.id.main_recyclerview1);
        relativeLayout2 = findViewById(R.id.main_recyclerview2);
        initdata();
        findViewById(R.id.main_image).setOnClickListener( this);
         findViewById(R.id.main_but).setOnClickListener(this);
        gridLayoutManager = new GridLayoutManager(this, 2,
                GridLayoutManager.VERTICAL, false);
        linerlayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        relativeLayout2.setLayoutManager(linerlayoutManager);

        adapter = new MyAdapter(this);
        relativeLayout2.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v) {
                int position = relativeLayout2.getChildAdapterPosition(v);
                List<Car> list = adapter.getList();
                Toast.makeText(HomeActivity.this, list.get(position).getImages()+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initdata() {
        myPresent = new MyPresent((BaseCar) this);
        myPresent.getCar();
        myPresent.getGoods();
    }

    @Override
    public void successpage(List<Car> car) {

        adapter.addList(car);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void successpgoods(List<Goods> goods) {
        Toast.makeText(this, goods.size()+"", Toast.LENGTH_SHORT).show();

        MyGridAdapter adapter1 = new MyGridAdapter(this);
        gridLayoutManager111 = new GridLayoutManager(this, 5,
                GridLayoutManager.VERTICAL, false);
        relativeLayout1.setLayoutManager(gridLayoutManager111);
        relativeLayout1.setAdapter(adapter1);
        adapter1.addList(goods);
        adapter1.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.main_but) {
            if (isGrid) {
                isGrid = false;
                adapter.setViewType(MyAdapter.GRID_TYPE);
                relativeLayout2.setLayoutManager(gridLayoutManager);
            } else {
                isGrid = true;
                adapter.setViewType(MyAdapter.LINEAR_TYPE);
                relativeLayout2.setLayoutManager(linerlayoutManager);
            }
        }

    }

}

