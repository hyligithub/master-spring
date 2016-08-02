package com.masterspring.common.arithmetic.com.stack;

/**
 * Created by lihuiyan on 2016/7/26.
 */
public class SeqStack<T> implements SStack<T> {
    private int top;
    private Object[] element;

    public SeqStack(int size) {
        element = new Object[size];
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void put(T o) {
        if (o == null)
            return;
        if (top == element.length - 1) {
            Object[] tmp = this.element;
            this.element = new Object[2 * element.length];
            for (int i = 0; i < tmp.length; i++) {
                element[i] = tmp[i];
            }
        }
        top++;
        this.element[top] = o;
    }

    @Override
    public T pop() {
        if (isEmpty())
            return null;
        return (T) this.element[top--];
    }

    @Override
    public T get() {
        return (T) this.element[top];
    }
}
