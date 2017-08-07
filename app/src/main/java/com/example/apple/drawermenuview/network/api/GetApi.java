package com.example.apple.drawermenuview.network.api;

import com.example.apple.drawermenuview.bean.CategoryResult;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by apple on 2017/8/7.
 */

public interface GetApi {
    @GET("data/{category}/{count}/{page}")
    Observable<CategoryResult> getCategoryData(@Path("category") String category, @Path("count")int count, @Path("page")int page);

}
