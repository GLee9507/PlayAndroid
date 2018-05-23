package com.glee.libbase.x;

import android.support.v7.view.menu.MenuView;
import android.view.ViewParent;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-21
 * Time: 4:28 PM
 */
public interface XViewGroup extends ViewParent {
    void showContent();

    void showError();

    void showLoading();

    void showNetError();

    void showEmpty();

    void checkState(LayoutState state);

//    public static final int ERROR = 0xAA;
//    public static final int NET_ERROR = 0xAB;
//    public static final int EMPTY = 0xAC;
//    public static final int LOADING = 0xAD;
//    public static final int CONTENT = 0xFF;

}
