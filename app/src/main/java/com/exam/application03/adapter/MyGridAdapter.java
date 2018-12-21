package com.exam.application03.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.exam.application03.R;
import com.exam.application03.bean.Car;
import com.exam.application03.bean.Goods;
import com.exam.application03.core.OnItemClickListener;
import com.exam.application03.core.OnLongItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MyGridAdapter extends RecyclerView.Adapter {



    private List<Goods> mList = new ArrayList<>();
    private Context context;


    //private ArrayList<NetData.DataBean> list = new ArrayList<>();
    public MyGridAdapter(Context context) {
        this.context = context;
    }
    public void addList(List<Goods> data){
        mList.addAll(data);
    }

    /**
     * hodler view 两种加载方式
     * ①：LayoutInflater.from(context).inflate(id,viewGroup,false);
     * ②：View.inflate(context,id,null)
     */
    //设置item的视图类型

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

            View view = View.inflate(context,R.layout.item,null);

                 MyHodler myHodler = new MyHodler(view);
        return myHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder  viewHolder, final int  i) {
         MyHodler myHodler = new MyHodler(viewHolder.itemView);

        String thumbnail_pic_s = mList.get(i).getIcon();

        Glide.with(context).load(thumbnail_pic_s).into(myHodler.imageView);
        String title1 =mList.get(i).getName();
        myHodler.title.setText(title1);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    class MyHodler extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView imageView;

        public MyHodler(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_text00);
            imageView = itemView.findViewById(R.id.item_image00);
        }
    }

}