package com.example.yinm_pc.videopro.http.callback;

public interface IGenericsSerializator {
    <T> T transform(String response, Class<T> classOfT);
}
