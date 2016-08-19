package com.example.yinm_pc.videopro.presenter;

import android.util.Log;

import com.example.yinm_pc.videopro.model.ListVideoModel;
import com.example.yinm_pc.videopro.model.ListVideoModelListener;
import com.example.yinm_pc.videopro.view.ListVideoListener;

import okhttp3.Request;

public class ListVideoPresenter extends BasePresenter implements ListVideoPresenterListener, ListVideoModel.OnLoadNewsListListener {

    private static final String TAG = ListVideoPresenter.class.getCanonicalName();
    private ListVideoListener listVideoListener;
    private ListVideoModelListener listVideoModel;

    public ListVideoPresenter(ListVideoListener listener) {
        this.listVideoListener = listener;
        this.listVideoModel = new ListVideoModel();
    }

    @Override
    public void loadVide(String url) {
        listVideoModel.loadVide(url, this);
    }

    @Override
    public void onSuccess(String url, String path) {
        listVideoListener.hideProgress(url);
    }

    @Override
    public void onFailure(String url, String msg, Exception e) {
        listVideoListener.hideProgress(url);
        listVideoListener.showLoadFailMsg(url);
    }

    @Override
    public void onBefore(String url, Request request, int id) {
        listVideoListener.showProgress(url, 0, 1);
    }

    @Override
    public void onProgress(String url, float progress, long total, int id) {
        listVideoListener.showProgress(url, progress, total);
    }


}
