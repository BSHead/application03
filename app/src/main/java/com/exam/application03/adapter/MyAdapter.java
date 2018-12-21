package com.exam.application03.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.exam.application03.R;
import com.exam.application03.bean.Car;
import com.exam.application03.core.OnItemClickListener;
import com.exam.application03.core.OnLongItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    public final static int LINEAR_TYPE = 0;//线性
    public final static int GRID_TYPE = 1;//网格

    private int viewType = LINEAR_TYPE;

    private List<Car> mList = new ArrayList<>();
    private Context context;

    //点击事件
    private OnItemClickListener mOnItemClickListener;
    private OnLongItemClickListener onLongItemClickListener;
    //点击事件
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
    public void setOnLongItemClickListener( OnLongItemClickListener onLongItemClickListener){
        this.onLongItemClickListener = onLongItemClickListener;
    }
    //private ArrayList<NetData.DataBean> list = new ArrayList<>();
    public MyAdapter(Context context) {
        this.context = context;
    }
    public void addList(List<Car> data){
        mList.addAll(data);
    }
    public List<Car> getList(){
        return mList;
    }
    public void clearList(){
        mList.clear();
        notifyDataSetChanged();
    }
    public void delList(int i){
        mList.remove(i);
        notifyDataSetChanged();
    }
    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
    @Override
    public int getItemViewType(int position) {
        return viewType;
    }

    /**
     * hodler view 两种加载方式
     * ①：LayoutInflater.from(context).inflate(id,viewGroup,false);
     * ②：View.inflate(context,id,null)
     */
    //设置item的视图类型

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view ;
        if (viewType==LINEAR_TYPE){
            view = View.inflate(context,R.layout.item2,null);

        }else {
            view = View.inflate(context,R.layout.item1,null);
        }
        MyHodler myHodler = new MyHodler(view);
        return myHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder  viewHolder, final int  i) {
        final MyHodler myHodler = new MyHodler(viewHolder.itemView);

        String thumbnail_pic_s = mList.get(i).getImages();
        String[] split = thumbnail_pic_s.split("\\|");
        Glide.with(context).load(split[0]).into(myHodler.imageView);
        String title1 =mList.get(i).getTitle();
        myHodler.title.setText(title1);
        if(onLongItemClickListener != null) {
            //为ItemView设置监听器
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onLongItemClickListener.onLongItemClick(v);
                   /* mList.remove(i);
                    notifyItemRemoved(i);*/
                    return false;
                }
            });

        }
        if(mOnItemClickListener != null) {
            //为ItemView设置监听器
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mOnItemClickListener.onItemClick(v);

                }
            });
        }
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
            title = itemView.findViewById(R.id.item_text);
            imageView = itemView.findViewById(R.id.item_image);
        }
    }

}