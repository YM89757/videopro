package com.example.yinm_pc.videopro.http.builder;


import com.example.yinm_pc.videopro.http.OkHttpUtils;
import com.example.yinm_pc.videopro.http.request.OtherRequest;
import com.example.yinm_pc.videopro.http.request.RequestCall;

public class HeadBuilder extends GetBuilder {
    @Override
    public RequestCall build() {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers, id).build();
    }
}
