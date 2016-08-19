package com.example.yinm_pc.videopro.model;

import android.os.Environment;
import android.util.Log;

import com.example.yinm_pc.videopro.http.OkHttpUtils;
import com.example.yinm_pc.videopro.http.callback.FileCallBack;

import java.io.File;

import okhttp3.Call;
import okhttp3.Request;

public class ListVideoModel implements ListVideoModelListener {
    private static final String TAG = ListVideoModel.class.getCanonicalName();

    @Override
    public void loadVide(final String url, final OnLoadNewsListListener listener) {
        OkHttpUtils
                .get()
                .url(url)
                .build()
                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), "textvideo.mp4")//
                {

                    @Override
                    public void onBefore(Request request, int id) {
                        listener.onBefore(url, request, id);
                        Log.i(TAG, "onBefore  " + id + "   " + url + "...");
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        listener.onProgress(url, progress, total, id);
                        Log.i(TAG, "inProgress  " + id + "   " + url + "     progress:" + progress + "   total:" + total);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        listener.onFailure(url, "", e);
                        Log.i(TAG, "onError  " + id + "   " + url + "...");
                    }

                    @Override
                    public void onResponse(File file, int id) {
                        listener.onSuccess(url, file.getAbsolutePath());
                        Log.i(TAG, "onResponse  " + id + "   " + url + "..." + file.getAbsolutePath());
                    }
                });
    }

    public interface OnLoadNewsListListener {
        void onSuccess(String url, String path);

        void onFailure(String url, String msg, Exception e);

        void onBefore(String url, Request request, int id);

        void onProgress(String url, float progress, long total, int id);
    }
}
