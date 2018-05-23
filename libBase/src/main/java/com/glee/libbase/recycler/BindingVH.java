package com.glee.libbase.recycler;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

import com.glee.libbase.util.BaseViewModel;


/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-20
 * Time: 12:10 PM
 */
public class BindingVH extends RecyclerView.ViewHolder {
    private final ViewDataBinding binding;
    private final ItemHolder holder;
    //    private final int variableId;

    BindingVH(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        holder = new ItemHolder();
    }

    public ItemHolder getHolder() {
        return holder;
    }

    public ViewDataBinding getBinding() {
        return binding;
    }

}
