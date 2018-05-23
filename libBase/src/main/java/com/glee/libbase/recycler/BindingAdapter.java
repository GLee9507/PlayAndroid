package com.glee.libbase.recycler;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-20
 * Time: 12:39 PM
 */
public class BindingAdapter extends RecyclerView.Adapter<BindingVH> {
    private LayoutInflater inflater;
    private @LayoutRes
    int layoutId = -1;
    private ObservableArrayList dataSet;
    private int variableId;
    //    private OnItemClickListener itemClickListener;
//    private OnItemLongClickListener longClickListener;
    private OnViewActionListener viewActionListener;

//    public void setItemClickListener(OnItemClickListener itemClickListener) {
//        this.itemClickListener = itemClickListener;
//    }
//
//    public void setLongClickListener(OnItemLongClickListener longClickListener) {
//        this.longClickListener = longClickListener;
//    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull BindingVH holder) {
        super.onViewDetachedFromWindow(holder);
    }

    public void setDataSet(final ObservableArrayListProxy dataSetProxy) {
        this.dataSet = dataSetProxy.getObservableArrayList();
        variableId = dataSetProxy.getVariableId();
        dataSet.addOnListChangedCallback(callback);
    }

    private ObservableList.OnListChangedCallback callback = new ObservableList.OnListChangedCallback() {
        @Override
        public void onChanged(ObservableList sender) {
            notifyDataSetChanged();
        }

        @Override
        public void onItemRangeChanged(ObservableList sender, int positionStart, int itemCount) {
            notifyItemRangeChanged(positionStart, itemCount);
        }

        @Override
        public void onItemRangeInserted(ObservableList sender, int positionStart, int itemCount) {
            notifyItemRangeInserted(positionStart, itemCount);
        }

        @Override
        public void onItemRangeMoved(ObservableList sender, int fromPosition, int toPosition, int itemCount) {
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onItemRangeRemoved(ObservableList sender, int positionStart, int itemCount) {
            notifyItemRangeRemoved(positionStart, itemCount);
        }
    };

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        if (inflater == null) {
            inflater = LayoutInflater.from(recyclerView.getContext());
        }

    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        dataSet.removeOnListChangedCallback(callback);
    }

    @NonNull
    @Override
    public BindingVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(inflater, layoutId, parent, false);
        BindingVH bindingVH = new BindingVH(binding);
        ItemHolder holder = bindingVH.getHolder();
        if (viewActionListener != null) {
            holder.setOnViewActionListener(viewActionListener);
        }
//        if (longClickListener != null) {
//            holder.setLongClickListener(longClickListener);
//        }
//        if (itemClickListener != null) {
//            holder.setClickListener(itemClickListener);
//        }
        return bindingVH;
    }

    @Override
    public void onBindViewHolder(@NonNull BindingVH holder, int position) {
        ViewDataBinding binding = holder.getBinding();
        ItemHolder itemHolder = holder.getHolder();
        itemHolder.setPosition(position);
        itemHolder.setData(dataSet.get(position));
        binding.setVariable(variableId, itemHolder);
    }

    @Override
    public int getItemCount() {
        return dataSet == null ? 0 : dataSet.size();
    }


    public void setViewActionListener(OnViewActionListener viewActionListener) {
        this.viewActionListener = viewActionListener;
    }
}
