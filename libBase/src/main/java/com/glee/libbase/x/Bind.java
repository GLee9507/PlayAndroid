package com.glee.libbase.x;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-22
 * Time: 9:57 AM
 */
public final class Bind {
    @android.databinding.BindingAdapter("checkState")
    public static void checkState(XConstraintLayout viewGroup, LayoutState state) {
        viewGroup.checkState(state);
    }

    @android.databinding.BindingAdapter("checkState")
    public static void checkState(XLinearLayout viewGroup, LayoutState state) {
        viewGroup.checkState(state);
    }
}
