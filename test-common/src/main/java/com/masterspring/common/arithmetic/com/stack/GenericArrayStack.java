package com.masterspring.common.arithmetic.com.stack;

import java.lang.reflect.Array;

/**
 * Created by lihuiyan on 2015/5/14.
 */
public class GenericArrayStack<T> {
    private static final int DEFAULT_SIZE = 12;
    private T[] array;
    private int count;

    public GenericArrayStack(Class<T> type) {
        this(type, DEFAULT_SIZE);
    }

    public GenericArrayStack(Class<T> type, int size) {
        array = (T[]) Array.newInstance(type, size);
        count = 0;
    }

    //???
    public void push(T val) {
        array[count++] = val;
    }

    //??????????
    public T peek() {
        T val = array[count - 1];
        return val;
    }

    //??????????????
    public T Pop() {
        T val = array[count - 1];
        count--;
        return val;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("the stack is empty");
        }
        int i = size() - 1;
        while (i >= 0) {
            System.out.println("the stack top is" + array[i--]);
        }
    }

    public static void main(String[] args) {
        GenericArrayStack<String> genericArrayStack = new GenericArrayStack<String>(String.class);
        genericArrayStack.push("10");
        genericArrayStack.push("20");
        genericArrayStack.push("30");
        genericArrayStack.printStack();

        String val = genericArrayStack.peek();

        System.out.println("peek,the stack top is " + val);
        String val1 = genericArrayStack.Pop();
        System.out.println("pop,the stack top is " + val);

        genericArrayStack.printStack();

    }
}
