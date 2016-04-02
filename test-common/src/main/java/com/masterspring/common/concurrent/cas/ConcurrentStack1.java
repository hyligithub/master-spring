package com.masterspring.common.concurrent.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by lihuiyan on 2016/4/2.
 */
public class ConcurrentStack1<E> {

    AtomicReference<Node<E>> head = new AtomicReference<Node<E>>();

    public E pop() {
        Node<E> oldHead;
        Node<E> newHead;
        do {
            oldHead = head.get();
            newHead = oldHead.next;
            if (oldHead == null) {
                return null;
            }
        } while (!head.compareAndSet(oldHead, newHead));
        return oldHead.item;
    }

    public void push(E item) {
        Node<E> oldHead;
        Node<E> newHead = new Node<E>(item);
        do {
            oldHead = head.get();
            newHead.next = oldHead;
        } while (head.compareAndSet(oldHead, newHead));
    }

    class Node<E> {
        final E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }


}
