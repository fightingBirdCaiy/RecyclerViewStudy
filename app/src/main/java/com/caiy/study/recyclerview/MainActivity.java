package com.caiy.study.recyclerview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.ChildHelper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private RecyclerView mRecyclerView;
    private HomeAdapter mHomeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initDatas();

        study();
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

    private void study(){
        studyBucket();
    }

    private void studyBucket() {
        ChildHelper.Bucket bucket = new ChildHelper.Bucket();
        bucket.set(3);
        Log.i(TAG,bucket.toString());//1000
        bucket.clear(3);
        Log.i(TAG,bucket.toString());//0
        bucket.set(4);
        Log.i(TAG,bucket.toString());//10000
        boolean has4 = bucket.get(4);
        Log.i(TAG,"has4=" + has4);//has4=true
        bucket.set(3);
        bucket.set(2);
        Log.i(TAG,bucket.toString());//11100
        int i = bucket.countOnesBefore(5);
        Log.i(TAG,"i=" + i);//i=3(前5位中bit为1的总数)
        int j = bucket.countOnesBefore(4);
        Log.i(TAG,"j=" + j);//j=2(前4位中bit为1的总数)
        bucket.reset();
        Log.i(TAG,bucket.toString());//0
        bucket.set(65);
        Log.i(TAG,bucket.toString());//10xx0
        bucket.reset();
        Log.i(TAG,bucket.toString());//0xx0
        bucket.set(6);
        bucket.set(5);
        Log.i(TAG,bucket.toString());//0xx1100000
        bucket.insert(6,false);
        Log.i(TAG,bucket.toString());//0xx10100000(6和5之间插入一位，插入的值为0)
        bucket.insert(6,true);
        Log.i(TAG,bucket.toString());//0xx101100000(6和5之间插入一位，插入的值为0)
        bucket.remove(6);
        Log.i(TAG,bucket.toString());//0xx10100000(移除位置6的bit)
    }
}
