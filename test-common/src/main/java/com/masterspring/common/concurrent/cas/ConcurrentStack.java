package com.masterspring.common.concurrent.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by lihuiyan on 2016/4/2.
 */
public class ConcurrentStack<E> {

    private AtomicReference<Node<E>> head = new AtomicReference<Node<E>>();

    public void push(E item) {
        Node<E> newhead = new Node<E>(item);
        Node<E> oldHead;
        do {
            oldHead = head.get();
            newhead.next = oldHead;
        } while (!head.compareAndSet(oldHead, newhead));
    }

    public E pop() {
        Node<E> newHead;
        Node<E> oldHead;
        do {
            oldHead = head.get();
            if (oldHead == null)
                return null;
            newHead = oldHead.next;
        } while (!head.compareAndSet(oldHead, newHead));
        return oldHead.item;
    }

    static class Node<E> {
        final E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }
}
