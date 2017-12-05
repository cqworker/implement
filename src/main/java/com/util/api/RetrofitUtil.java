package com.util.api;

import okhttp3.*;


/**
 * Created by cq
 * date: 11/20 0020
 */
public class RetrofitUtil {
    //为所有接口请求中添加token
    public static OkHttpClient genericClient(String token) {
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request()
                            .newBuilder()
                            .addHeader("Content-Type", "application/json; charset=UTF-8")
                            // .addHeader("Accept-Encoding", "gzip, deflate")
                            // .addHeader("Connection", "keep-alive")
                            // .addHeader("Accept", "*/*")
                            //.addHeader("Cookie", "add cookies here")
                            .addHeader("x-token", token)
                            .build();
                    return chain.proceed(request);
                })
                .build();
        return httpClient;
    }
}
