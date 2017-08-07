package com.example.apple.drawermenuview.network;

import com.example.apple.drawermenuview.network.api.GetApi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by apple on 2017/8/7.
 */

public class NetworkUtils {

    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static GetApi getApi;

    public static GetApi getNetDataApi(){
        if (getApi == null){
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://gank.io/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            getApi = retrofit.create(GetApi.class);
        }

        return getApi;
    }
}
