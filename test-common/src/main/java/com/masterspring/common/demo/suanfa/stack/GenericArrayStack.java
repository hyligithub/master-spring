package com.masterspring.common.demo.suanfa.stack;

import java.lang.reflect.Array;

/**
 * Created by lihuiyan on 2016/5/28.
 */
public class GenericArrayStack<T> {
    private static final int DEFAULT_SIZE = 12;

    private int mCount;

    public T[] mArray;

    public GenericArrayStack(Class<T> type) {
        this(type, DEFAULT_SIZE);
    }

    public GenericArrayStack(Class<T> type, int size) {
        mArray = (T[]) Array.newInstance(type, size);
        this.mCount = 0;
    }

    public void push(T val) {
        mArray[mCount++] = val;
    }

    public T peek() {
        return mArray[mCount - 1];
    }

    public T pop() {
        T ret = mArray[mCount - 1];
        mCount--;
        return ret;
    }

    public int size() {
        return mCount;
    }

    public boolean isEmpty() {
        return mCount == 0;
    }
}
