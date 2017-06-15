package com.caiy.study.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by yongc on 2017/6/15.
 */

public class FirstViewHolder extends RecyclerView.ViewHolder{

    private TextView mContentView;

    public FirstViewHolder(View itemView) {
        super(itemView);
        mContentView = (TextView) itemView.findViewById(R.id.content_tv);
    }

    public void onBind(HomeBean data) {
        mContentView.setText("FirstViewHolder" + data.position);
    }
}
