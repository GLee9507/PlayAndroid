package com.glee.libbase.util;


import com.glee.libbase.BuildConfig;
import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-20
 * Time: 3:46 PM
 */
public class Net {
    private static volatile Api api = null;

    private Net() {
    }

    public static Api getApi() {

        if (api == null) {
            synchronized (Net.class) {
                if (api == null) {
                    api = new Retrofit.Builder()
                            .baseUrl("http://www.wanandroid.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(new OkHttpClient.Builder()
                                    .writeTimeout(30, TimeUnit.SECONDS)
                                    .readTimeout(10, TimeUnit.SECONDS)
                                    .addInterceptor(new LoggingInterceptor.Builder()
                                            .loggable(BuildConfig.DEBUG)
                                            .setLevel(Level.BASIC)
                                            .log(Platform.INFO)
                                            .request("Request")
                                            .response("Response")
                                            .tag("sfyNet")
                                            .addHeader("version", BuildConfig.VERSION_NAME)
                                            .addQueryParam("query", "0")
                                            .build())
                                    .build())
                            .build()
                            .create(Api.class);
                }
            }
        }
        return api;
    }
}
