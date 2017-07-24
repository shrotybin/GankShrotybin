package com.example.shrotbin.gankshrotybin.api;

import com.example.shrotbin.gankshrotybin.bean.HeaderImage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * <pre>
 *     author : shortbin
 *     e-mail : xxx@xx
 *     time   : 2017/07/24
 *     desc   : xxxx描述
 *     version: 1.0
 * </pre>
 */

public interface GankApi {

    @GET("福利/count/10/page/{page}")
    Call<HeaderImage> getHeaderImage(@Path("page") int page);

}
