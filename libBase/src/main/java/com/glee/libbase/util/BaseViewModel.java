package com.glee.libbase.util;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.glee.libbase.recycler.OnViewActionListener;
import com.glee.libbase.refresh.State;
import com.glee.libbase.x.LayoutState;

import io.reactivex.disposables.CompositeDisposable;

import static com.glee.libbase.x.LayoutState.CONTENT;
import static com.glee.libbase.x.LayoutState.EMPTY;
import static com.glee.libbase.x.LayoutState.ERROR;
import static com.glee.libbase.x.LayoutState.LOADING;
import static com.glee.libbase.x.LayoutState.NET_ERROR;


/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-20
 * Time: 3:36 PM
 */
public class BaseViewModel extends AndroidViewModel {

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }



    /**************************** 网络请求部分 *****************************/
    protected Api getNet() {

        return Net.getApi();
    }

    private CompositeDisposable compositeDisposable;

    public CompositeDisposable getCompositeDisposable() {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        return compositeDisposable;
    }


    protected void cancelNetWork() {
        compositeDisposable.clear();
    }


    @Override
    protected void onCleared() {
        cancelNetWork();
        super.onCleared();
    }

    /**************************** 网络请求部分end *****************************/





    private MutableLiveData<LayoutState> viewState;

    public MutableLiveData<LayoutState> getViewState() {
        if (viewState == null) {
            viewState = new MutableLiveData<>();
        }
        return viewState;
    }

    protected void showContent() {
        if (getViewState().getValue() == CONTENT) {
            return;
        }
        getViewState().setValue(CONTENT);
    }

    protected void showLoading() {
        if (getViewState().getValue() == LOADING) {
            return;
        }
        getViewState().setValue(LOADING);
    }

    protected void showError() {
        if (getViewState().getValue() == ERROR) {
            return;
        }
        getViewState().setValue(ERROR);
    }

    protected void showNetError() {
        if (getViewState().getValue() == NET_ERROR) {
            return;
        }
        getViewState().setValue(NET_ERROR);
    }

    protected void showEmpty() {
        if (getViewState().getValue() == EMPTY) {
            return;
        }
        getViewState().setValue(EMPTY);
    }
}
