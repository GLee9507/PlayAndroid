package com.glee.libbase.recycler;

import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created with Android Studio.
 * OS: Arch Linux
 * Description:
 * User: Liji
 * Date: 2018-05-20
 * Time: 2:52 PM
 */
public class ObservableArrayListProxy<E> implements List<E> {
    private ObservableArrayList<E> observableArrayList;
   private int  variableId;

    public int getVariableId() {
        return variableId;
    }

    public void setVariableId(int variableId) {
        this.variableId = variableId;
    }

//    public ObservableArrayListProxy(ObservableArrayList<E> observableArrayList) {
//        this.observableArrayList = observableArrayList;
//    }

    public ObservableArrayListProxy(int variableId) {
        this.variableId = variableId;
        observableArrayList = new ObservableArrayList<>();
    }

//    public ObservableArrayListProxy(List<E> list) {
//        observableArrayList = new ObservableArrayList<>();
//        observableArrayList.addAll(list);
//    }

    public ObservableArrayList<E> getObservableArrayList() {
        return observableArrayList;
    }


    @Override
    public int size() {
        return observableArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return observableArrayList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return observableArrayList.contains(o);
    }

    @NonNull
    @Override
    public Iterator<E> iterator() {
        return observableArrayList.iterator();
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return observableArrayList.toArray();
    }

    @NonNull
    @Override
    public <T> T[] toArray(@NonNull T[] a) {
        return observableArrayList.toArray(a);
    }

    @Override
    public boolean add(E e) {
        return observableArrayList.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return observableArrayList.remove(o);
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> c) {
        return observableArrayList.containsAll(c);
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends E> c) {
        return observableArrayList.addAll(c);
    }

    @Override
    public boolean addAll(int index, @NonNull Collection<? extends E> c) {
        return observableArrayList.addAll(index, c);
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> c) {
        return observableArrayList.removeAll(c);
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> c) {
        return observableArrayList.retainAll(c);
    }

    @Override
    public void clear() {
        observableArrayList.clear();
    }

    @Override
    public E get(int index) {
        return observableArrayList.get(index);
    }

    @Override
    public E set(int index, E element) {
        return observableArrayList.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        observableArrayList.add(index, element);
    }

    @Override
    public E remove(int index) {
        return observableArrayList.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return observableArrayList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return observableArrayList.lastIndexOf(o);
    }

    @NonNull
    @Override
    public ListIterator<E> listIterator() {
        return observableArrayList.listIterator();
    }

    @NonNull
    @Override
    public ListIterator<E> listIterator(int index) {
        return observableArrayList.listIterator(index);
    }

    @NonNull
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return observableArrayList.subList(fromIndex, toIndex);
    }
}
