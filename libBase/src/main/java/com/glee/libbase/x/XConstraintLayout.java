package com.glee.libbase.x;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.util.AttributeSet;
import android.view.View;

import com.glee.libbase.R;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description: 多状态约束布局
 * User: Liji
 * Date: 2018-05-21
 * Time: 3:59 PM
 */
public class XConstraintLayout extends ConstraintLayout implements XViewGroup {

    public XConstraintLayout(Context context) {
        super(context);
    }


    public XConstraintLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public XConstraintLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private View errorView, netErrorView, loadingView, emptyView;
    private int errorId, netErrorId, loadingId, emptyId;


    @Override
    public void showContent() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(VISIBLE);
        }
        if (errorView != null) {
            errorView.setVisibility(GONE);
        }
        if (netErrorView != null) {
            netErrorView.setVisibility(GONE);
        }
        if (loadingView != null) {
            loadingView.setVisibility(GONE);
        }
    }

    @Override
    public void showError() {
        if (errorView == null) {
            errorView = createView(errorId);
        }
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(GONE);
        }
        errorView.setVisibility(VISIBLE);
    }


    @Override
    public void showLoading() {
        if (loadingView == null) {
            loadingView = createView(loadingId);
        }
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(GONE);
        }
        loadingView.setVisibility(VISIBLE);
    }

    @Override
    public void showNetError() {
        if (netErrorView == null) {
            netErrorView = createView(netErrorId);
        }
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(GONE);
        }
        netErrorView.setVisibility(VISIBLE);

    }

    @Override
    public void showEmpty() {
        if (emptyView == null) {
            emptyView = createView(emptyId);
        }
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(GONE);
        }
        emptyView.setVisibility(VISIBLE);
    }

    @Override
    public void checkState(LayoutState state) {
        if (state == null) {
            return;
        }
        switch (state) {
            case CONTENT:
                showContent();
                break;
            case LOADING:
                showLoading();
                break;
            case ERROR:
                showError();
                break;
            case EMPTY:
                showEmpty();
                break;
            case NET_ERROR:
                showNetError();
                break;
        }
    }

    private void init(AttributeSet attrs) {
        @SuppressLint("CustomViewStyleable") TypedArray array = getContext().obtainStyledAttributes(attrs, R.styleable.XViewGroup);
        errorId = array.getResourceId(R.styleable.XViewGroup_errorView, R.layout.error_view_sample);
        netErrorId = array.getResourceId(R.styleable.XViewGroup_netErrorView, R.layout.net_error_view_sample);
        loadingId = array.getResourceId(R.styleable.XViewGroup_loadingView, R.layout.loading_view_sample);
        emptyId = array.getResourceId(R.styleable.XViewGroup_emptyView, R.layout.empty_view_sample);
        boolean loadingStart = array.getBoolean(R.styleable.XViewGroup_loadingStart, false);
        array.recycle();
        if (loadingStart) {
            post(this::showLoading);
        }
    }

    private View createView(int id) {
        View view = inflate(getContext(), id, null);
        LayoutParams params = new Constraints.LayoutParams(-1, -1);
        params.topToTop = 0;
        params.leftToLeft = 0;
        params.rightToRight = 0;
        params.bottomToBottom = 0;
        view.setLayoutParams(params);
        addView(view);
        return view;
    }
}
