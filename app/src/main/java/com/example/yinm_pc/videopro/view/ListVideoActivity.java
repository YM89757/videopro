package com.example.yinm_pc.videopro.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.yinm_pc.videopro.Bean.ListVideoBean;
import com.example.yinm_pc.videopro.R;
import com.example.yinm_pc.videopro.adapter.ListVideoAdapter;

import java.util.ArrayList;

/**
 * Created by zjq on 16/8/18.
 */
public class ListVideoActivity extends Activity implements ListVideoAdapter.OnItemClickLitener {
    private RecyclerView recyclerView;
    private ArrayList<ListVideoBean> dateArr;
    ListVideoAdapter adapter;
    private static final String TAG = ListVideoActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listavideo);
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
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i(TAG, position + "...");
    }
}
