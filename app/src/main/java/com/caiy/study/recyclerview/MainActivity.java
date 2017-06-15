package com.caiy.study.recyclerview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends Activity {

    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initDatas();
    }

    private void initView() {
        mRecyclerView = (RecyclerView)findViewById(R.id.content_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mHomeAdapter = new HomeAdapter(this);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    private void initDatas() {
        List<HomeBean> homeBeans = new ArrayList<HomeBean>();
        for(int i=0;i<50;i++){
            HomeBean homeBean = new HomeBean(i,"name"+i,1);
            homeBeans.add(homeBean);
        }
        mHomeAdapter.setDatas(homeBeans);
    }

}
