package com.example.yinm_pc.videopro.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.yinm_pc.videopro.bean.ListVideoBean;
import com.example.yinm_pc.videopro.R;
import com.example.yinm_pc.videopro.adapter.ListVideoAdapter;
import com.example.yinm_pc.videopro.presenter.ListVideoPresenter;

import java.util.ArrayList;
import java.util.List;


public class ListVideoActivity extends Activity implements ListVideoAdapter.OnItemClickLitener, ListVideoListener

{
    private RecyclerView recyclerView;
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
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
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
            dateArr.add(listVideoBean);
        }
        listVideoPresenter.loadVide("http://imgcdn.imdouya.com/100376_AB61A23A-9A63-430A-BC30-34DEC1A3205A_1471594887_-1401661027?imageView2/0/format/webp?vframe/png/offset/0/w/360/h/600");
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i(TAG, position + "...");
    }

    @Override
    public void showProgress(String url, float progress, long total) {

    }

    @Override
    public void addNews(List<ListVideoBean> newsList) {

    }

    @Override
    public void hideProgress(String url) {

    }

    @Override
    public void showLoadFailMsg(String url) {

    }
}
