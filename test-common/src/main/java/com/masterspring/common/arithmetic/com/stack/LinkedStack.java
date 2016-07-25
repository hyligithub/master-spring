package com.masterspring.common.arithmetic.com.stack;

/**
 * Created by lihuiyan on 2016/7/25.
 */
public class LinkedStack<T> {

    private int count;

    private StackNode<T> top;


    private class StackNode<T> {
        private T v;
        private StackNode next;

        public StackNode(T value, StackNode next) {
            this.v = value;
            this.next = next;
        }
    }

    public LinkedStack() {
        top = new StackNode<T>(null, null);
    }

    public void push(StackNode<T> node) {
        node.next = top;
        top = node;
    }

    public StackNode<T> pop() {
        StackNode<T> toptemp = top;
        top = top.next;
        return toptemp;
    }

    public boolean isEmpty() {
        return top.next == null;
    }
}
