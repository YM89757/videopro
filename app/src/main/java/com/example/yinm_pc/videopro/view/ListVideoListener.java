package com.example.yinm_pc.videopro.view;

import com.example.yinm_pc.videopro.bean.ListVideoBean;

import java.util.List;

public interface ListVideoListener {
    void showProgress(String url, float progress, long total);

    void addNews(List<ListVideoBean> newsList);

    void hideProgress(String url);

    void showLoadFailMsg(String url);
}
