package com.glee.libbase.x;

import android.graphics.Color;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

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

    @android.databinding.BindingAdapter("textSpannable")
    public static void textSpannable(TextView textView, String text) {
        SpannableString sp = new SpannableString(text);
        sp.setSpan(new ForegroundColorSpan(Color.BLUE), 3, text.length(), Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(sp);
    }
}
