package com.masterspring.common.generic;

/**
 * Created by lihuiyan on 2016/3/17.
 */
public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<T>();

    public void push(T item) {
        top = new Node<T>(item, top);
    }

    public T pop() {
        T item = top.item;
        if (!top.end())
            top = top.next;
        return item;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss
                = new LinkedStack<String>();
        for (String s : "Person is OK".split(" ")) {
            lss.push(s);
        }
        String item;
        while ((item = lss.pop()) != null) {
            System.out.println(item);
        }
    }
}
