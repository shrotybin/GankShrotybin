package com.example.shrotbin.gankshrotybin.net;

import com.example.shrotbin.gankshrotybin.api.GankApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/07/24
 *     desc   : xxxx描述
 *     version: 1.0
 * </pre>
 */

public class RetrofitFactory {

    public final GankApi mGankApi;

    public RetrofitFactory() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.connectTimeout(15, TimeUnit.SECONDS);
        OkHttpClient build = client.build();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://gank.io/api/search/query/listview/category/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(build);

        Retrofit retrofit = builder.build();
        mGankApi = retrofit.create(GankApi.class);
    }

    public GankApi getGankApi() {
        return mGankApi;
    }

}
