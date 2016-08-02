package com.masterspring.common.arithmetic.com.stack;

/**
 * Created by lihuiyan on 2016/7/26.
 */
public interface SStack<T> {
    public boolean isEmpty();

    public void put(T t);

    public T pop();

    public T get();
}
