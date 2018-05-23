package com.glee.libbase.util;


import com.glee.libbase.bean.ArticleBean;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-20
 * Time: 9:38 PM
 */
public interface Api {
    @GET
    Observable<Response<ArticleBean>> getMainList(@Url String url);
}
