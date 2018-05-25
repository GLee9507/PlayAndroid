package com.glee.libbase.util;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.glee.libbase.recycler.OnViewActionListener;
import com.glee.libbase.refresh.State;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-23
 * Time: 4:44 PM
 */
public class BaseVmWithRefresh extends BaseViewModel implements OnViewActionListener {
    public BaseVmWithRefresh(@NonNull Application application) {
        super(application);
    }


    /**************************** RefreshLayout部分 *****************************/

    @State
    private int refreshing_or_loading = State.NOTHING;
    private MutableLiveData<Integer> refreshState;

    public MutableLiveData<Integer> getRefreshState() {
        if (refreshState == null) {
            refreshState = new MutableLiveData<>();
        }
        return refreshState;
    }

    @Override
    public void onAction(@IdRes int viewId, int action, int position) {
        if (action == Action.LOAD_MORE) {
            refreshing_or_loading = State.LOADING;
            onLoadMore();
        } else if (action == Action.REFRESH) {
            refreshing_or_loading = State.REFRESHING;
            onRefresh();
        }
    }

    protected void finishRefresh(boolean success) {
        if (refreshing_or_loading == State.REFRESHING) {
            getRefreshState().setValue(success ? State.REFRESH_SUCCESS : State.REFRESH_FAILED);
            refreshing_or_loading = State.NOTHING;
        }
    }

    protected void finishLoadMore(boolean success) {
        if (refreshing_or_loading == State.LOADING) {
            getRefreshState().setValue(success ? State.LOAD_SUCCESS : State.LOAD_FAILED);
            refreshing_or_loading = State.NOTHING;
        }
    }

    protected void finishLoadMoreNoData() {
        if (refreshing_or_loading == State.LOADING) {
            getRefreshState().setValue(State.LOAD_NO_MORE);
            refreshing_or_loading = State.NOTHING;
        }
    }

    protected void onRefresh() {
    }

    protected void onLoadMore() {
    }

}
