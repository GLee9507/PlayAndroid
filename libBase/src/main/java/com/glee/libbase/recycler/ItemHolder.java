package com.glee.libbase.recycler;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-21
 * Time: 1:27 PM
 */
public class ItemHolder<T> {
    private int position;
    private OnViewActionListener actionListener;

    public OnViewActionListener getActionListener() {
        return actionListener;
    }

    public void setOnViewActionListener(OnViewActionListener onViewActionListener) {
        this.actionListener = onViewActionListener;
    }




    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
