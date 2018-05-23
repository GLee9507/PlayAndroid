package com.glee.libbase.refresh;

import android.databinding.BindingAdapter;

import com.glee.libbase.util.Action;
import com.glee.libbase.recycler.OnViewActionListener;
import com.glee.libbase.util.BaseViewModel;
import com.glee.libbase.util.BaseVmWithRefresh;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-22
 * Time: 11:21 AM
 */
public class Bind {
//    @BindingAdapter(value = {"refreshListener", "loadMoreListener", "allListener"}, requireAll = false)
//    public static void initRefreshLayout(SmartRefreshLayout refreshLayout,
//                                         OnRefreshListener onRefreshListener,
//                                         OnLoadMoreListener onLoadMoreListener,
//                                         OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
//        if (refreshLayout.getRefreshFooter() == null) {
//            refreshLayout.setRefreshFooter(new ClassicsFooter(refreshLayout.getContext()));
//        }
//        if (refreshLayout.getRefreshHeader() == null) {
//            refreshLayout.setRefreshHeader(new ClassicsHeader(refreshLayout.getContext()));
//        }
//        if (onRefreshListener != null) {
//            refreshLayout.setOnRefreshListener(onRefreshListener);
//        }
//
//        if (onLoadMoreListener != null) {
//            refreshLayout.setOnLoadMoreListener(onLoadMoreListener);
//        }
//
//        if (onRefreshLoadMoreListener != null) {
//            refreshLayout.setOnRefreshLoadMoreListener(onRefreshLoadMoreListener);
//        }
//
//    }

    @BindingAdapter("actionListener")
    public static void initRefreshLayout(SmartRefreshLayout refreshLayout,
                                         BaseVmWithRefresh actionListener) {
        if (refreshLayout.getRefreshFooter() == null) {
            refreshLayout.setRefreshFooter(new ClassicsFooter(refreshLayout.getContext()));
        }
        if (refreshLayout.getRefreshHeader() == null) {
            refreshLayout.setRefreshHeader(new ClassicsHeader(refreshLayout.getContext()));
        }
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                actionListener.onAction(((SmartRefreshLayout) refreshLayout).getId(), Action.LOAD_MORE, -1);
            }

            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                actionListener.onAction(((SmartRefreshLayout) refreshLayout).getId(), Action.REFRESH, -1);
            }
        });
    }

    @BindingAdapter("refreshState")
    public static void refreshState(SmartRefreshLayout refreshLayout, int state) {
        switch (state) {
            case State.REFRESH_SUCCESS:
//                if (refreshLayout.isRefreshing()) {
                    refreshLayout.finishRefresh(true);
//                }
                break;
            case State.REFRESH_FAILED:
//                if (refreshLayout.isRefreshing()) {
                    refreshLayout.finishRefresh(false);
//                }
                break;
            case State.LOAD_SUCCESS:
//                if (refreshLayout.isLoading()) {
                    refreshLayout.finishLoadMore(true);
//                }
                break;
            case State.LOAD_FAILED:
//                if (refreshLayout.isLoading()) {
                    refreshLayout.finishLoadMore(false);
//                }
                break;
            case State.LOAD_NO_MORE:
//                if (refreshLayout.isLoading()) {
                    refreshLayout.finishLoadMoreWithNoMoreData();
//                }
                break;
        }
    }
}
