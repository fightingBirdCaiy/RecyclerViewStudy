package com.caiy.study.recyclerview;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yongc on 2017/6/15.
 */

public class HomeAdapter extends RecyclerView.Adapter<FirstViewHolder>{

    private Context mContext;

    private List<HomeBean> mDatas = new ArrayList<HomeBean>();

    public HomeAdapter(Context context){
        mContext = context;
    }

    @Override
    public FirstViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.first_layout,parent,false);
        return new FirstViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FirstViewHolder holder, int position) {
        HomeBean data = mDatas.get(position);
        data.position = position;
        holder.onBind(data);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void setDatas(List<HomeBean> datas){
        mDatas.clear();
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public void addDatas(List<HomeBean> datas){
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }
}
