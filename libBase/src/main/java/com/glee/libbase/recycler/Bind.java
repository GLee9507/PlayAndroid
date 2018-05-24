package com.glee.libbase.recycler;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.glee.libbase.util.BaseViewModel;
import com.glee.libbase.x.XConstraintLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-20
 * Time: 1:28 PM
 */
public final class Bind {
    @android.databinding.BindingAdapter(value = {"itemLayout", "dataSet", "actionListener"}, requireAll = false)
    public static <T> void initRecyclerView(RecyclerView recyclerView,
                                            @LayoutRes int id,
                                            ObservableArrayListProxy<T> dataSet,
                                            OnViewActionListener actionListener) {
        BindingAdapter adapter = (BindingAdapter) recyclerView.getAdapter();
        recyclerView.setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        if (adapter == null) {
//            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            adapter = new BindingAdapter();
            adapter.setLayoutId(id);
            if (actionListener != null) {
                adapter.setViewActionListener(actionListener);
            }
//            if (onItemClickListener != null) {
//                adapter.setItemClickListener(onItemClickListener);
//            }
//            if (onItemLongClickListener != null) {
//                adapter.setLongClickListener(onItemLongClickListener);
//            }

            recyclerView.setAdapter(adapter);
        }
        if (dataSet != null) {
            adapter.setDataSet(dataSet);
        }
    }


}
