package com.masterspring.common.arithmetic.com.stack.getminstack;

import java.util.Stack;

/**
 * Created by lihuiyan on 2016/1/26.
 */
public class MyStack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Integer pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("this stack is empty");
        }
        int value = stackData.pop();
        if (value == this.getMin())
            stackMin.pop();
        return value;
    }

    public void push(int newNum) {
        stackData.push(newNum);
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        }
        if (newNum <= getMin()) {
            stackMin.push(newNum);
        }
    }

    public int getMin() {
        return stackMin.peek();
    }
}
