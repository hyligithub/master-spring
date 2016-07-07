package com.masterspring.common.arithmetic.com.stack;

import java.util.Stack;

/**
 * Created by lihuiyan on 2016/1/26.
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStackQueue() {
        stackPop = new Stack<Integer>();
        stackPush = new Stack<Integer>();
    }

    public void push(int value) {
        stackPush.push(value);
    }

    public int poll() {
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
        return stackPop.pop();
    }

    public int peek() {
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        int[] a = {3, 5, 2, 1};
        for (int i = 0; i < a.length; i++) {
            twoStackQueue.push(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
         System.out.println(   twoStackQueue.poll());
        }
        for (int i = 0; i < a.length; i++) {
            twoStackQueue.poll();
        }
    }
}
