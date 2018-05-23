package com.glee.libbase.util;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.glee.libbase.util.Action.CLICK;
import static com.glee.libbase.util.Action.LIST_ITEM_CLICK;
import static com.glee.libbase.util.Action.LIST_ITEM_LONG_CLICK;
import static com.glee.libbase.util.Action.LOAD_MORE;
import static com.glee.libbase.util.Action.LONG_CLICK;
import static com.glee.libbase.util.Action.REFRESH;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-23
 * Time: 1:40 PM
 */
@IntDef({CLICK, LONG_CLICK, LIST_ITEM_CLICK, LIST_ITEM_LONG_CLICK,REFRESH,LOAD_MORE})
@Retention(RetentionPolicy.SOURCE)
public @interface Action {
    int CLICK = 666;
    int LONG_CLICK = 667;
    int LIST_ITEM_CLICK = 668;
    int LIST_ITEM_LONG_CLICK = 669;
    int REFRESH = 670;
    int LOAD_MORE = 671;
}
