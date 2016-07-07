package com.masterspring.common.arithmetic.com.stack.getminstack;


import java.util.Stack;

/**
 * Created by lihuiyan on 2016/1/26.
 */
public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack2() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newMin) {
        if (stackMin.isEmpty())
            stackMin.push(newMin);
        else if (newMin < getMin()) {
            stackMin.push(newMin);
        } else {
            int value = stackMin.peek();
            stackMin.push(value);
        }
        stackData.push(newMin);
    }

    public int pop() {
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MyStack2 myStack2 = new MyStack2();
        int a[] = {3, 4, 5, 1, 2, 1};
        for (int i = 0; i < a.length; i++) {
            myStack2.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            int min = myStack2.getMin();
            int value = myStack2.pop();
            System.out.println(min + "--" + value);
        }
    }
}
