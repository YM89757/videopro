package com.example.yinm_pc.videopro.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.yinm_pc.videopro.R;
import com.example.yinm_pc.videopro.adapter.ListVideoAdapter;
import com.example.yinm_pc.videopro.bean.ListVideoBean;
import com.example.yinm_pc.videopro.presenter.ListVideoPresenter;

import java.util.ArrayList;
import java.util.List;


public class ListVideoActivity extends Activity implements ListVideoAdapter.OnItemClickLitener, ListVideoListener

{
    private ArrayList<ListVideoBean> dateArr;
    private ListVideoAdapter adapter;
    private ListVideoPresenter listVideoPresenter;
    private static final String TAG = ListVideoActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listavideo);

        listVideoPresenter = new ListVideoPresenter(this);

        initData();
        initView();
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        adapter = new ListVideoAdapter(this, dateArr);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.setOnItemClickLitener(this);
    }

    private void initData() {
        dateArr = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            ListVideoBean listVideoBean = new ListVideoBean();
            listVideoBean.setVideoString("第" + i + "个视频");
            listVideoBean.setPath("/storage/emulated/0/textvideo.mp4");
            dateArr.add(listVideoBean);
        }

    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i(TAG, position + "...");
        listVideoPresenter.loadVide("http://gslb.miaopai.com/stream/t~gB32Ha~0TyT3~Uju8bqQ__.mp4?vend=miaopai&");
    }

    @Override
    public void onItemLongClick(View view, int position) {
        adapter.removeData(position);
    }

    @Override
    public void showProgress(String url, float progress, long total) {

    }

    @Override
    public void addNews(List<ListVideoBean> newList) {
        adapter.addItem( newList);
    }

    @Override
    public void hideProgress(String url) {

    }

    @Override
    public void showLoadFailMsg(String url) {

    }
}
