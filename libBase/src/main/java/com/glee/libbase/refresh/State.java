package com.glee.libbase.refresh;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-23
 * Time: 2:49 PM
 */

@IntDef({State.LOAD_SUCCESS, State.LOAD_FAILED, State.LOAD_NO_MORE, State.REFRESH_FAILED, State.REFRESH_SUCCESS,State.LOADING,State.REFRESHING,State.NOTHING})
@Retention(RetentionPolicy.SOURCE)
public @interface State {
    int LOAD_SUCCESS = 222;
    int LOAD_FAILED = 223;
    int LOAD_NO_MORE = 224;
    int REFRESH_SUCCESS = 225;
    int REFRESH_FAILED = 226;
    int LOADING = 227;
    int REFRESHING = 228;
    int NOTHING = 229;
}
