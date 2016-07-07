package com.masterspring.common.generic;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/6/6.
 */
public class LinkedStack2<T> {
    private class Node {
        T item;
        Node next;

        Node() {
            item = null;
            next = null;
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node top = new Node();

    public void push(T item) {
        top = new Node(item, top);
    }

    public T pop() {
        if (top.end()) return null;
        else {
            T result = top.item;
            top = top.next;
            return result;
        }
    }

    public static void main(String[] args) {
        LinkedStack2<String> lls2 = new LinkedStack2<String>();
        for (String s : "hello world aa".split(" ")) {
            lls2.push(s);
        }
        String s;
        while ((s = lls2.pop()) != null) {
            PrintUtil.print(s);
        }
    }
}
