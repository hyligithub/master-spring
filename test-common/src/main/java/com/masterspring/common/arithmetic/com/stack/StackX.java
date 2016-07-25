package com.masterspring.common.arithmetic.com.stack;

/**
 * Created by lihuiyan on 2016/7/25.
 */
public class StackX {
    private final static int SIZE = 16;
    private int[] array;
    private int top;

    public StackX() {
        array = new int[SIZE];
        top = -1;
    }

    public void push(int v) {
        array[++top] = v;
    }

    public int pop() {

        int v = array[top];
        top--;
        return v;
    }

    public int peek() {
        int v = array[top];
        return v;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
