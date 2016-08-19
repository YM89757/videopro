package com.example.yinm_pc.videopro.http.builder;

import java.util.Map;

public interface HasParamsable {
    OkHttpRequestBuilder params(Map<String, String> params);

    OkHttpRequestBuilder addParams(String key, String val);
}
