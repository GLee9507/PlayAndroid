package com.glee.libbase.recycler;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;

import com.glee.libbase.util.Action;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-23
 * Time: 1:39 PM
 */
public interface OnViewActionListener {
    void onAction(@IdRes int viewId, @Action int action, int position);
}
