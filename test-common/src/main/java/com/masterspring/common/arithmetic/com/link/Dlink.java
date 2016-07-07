package com.masterspring.common.arithmetic.com.link;

/**
 * Created by lihuiyan on 2015/5/14.
 */
public class Dlink<T> {

    private DNode mHead;
    private int count;

    public Dlink() {
        mHead = new DNode(null, null, null);
        mHead.pre = mHead.next = mHead;
        count = 0;

    }

    class DNode<T> {
        private T value;
        private DNode pre;
        private DNode next;

        public DNode(T t, DNode pre, DNode next) {
            this.value = t;
            this.pre = pre;
            this.next = next;
        }
    }

    public DNode<T> getNode(int index) {
        //˳�����
        if (index < count / 2) {
            DNode node = mHead.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }

        //�������
        DNode node = mHead.pre;
        int rindex = count - index - 1;
        for (int j = 0; j < rindex; j++) {
            node = node.pre;
        }
        return node;
    }

    public DNode<T> getFirst() {
        return this.getNode(0);
    }

    public T getValue(int index) {
        return getNode(index).value;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void appendLast(T t) {
        DNode<T> dNode = new DNode<T>(t, mHead.pre, mHead);
        mHead.pre.next = dNode;
        mHead.pre = dNode;
        count++;
    }

    public void insert(int index, T t) {
        if (index == 0) {
            DNode<T> dNode = new DNode(t, mHead, mHead.next);
            mHead.next.pre = dNode;
            mHead.next = dNode;
            count++;
            return;
        }
        DNode<T> dNode = getNode(index);
        DNode<T> newNode = new DNode<T>(t, dNode.pre, dNode);
        dNode.pre.next = newNode;
        dNode.pre = newNode;
        count++;
        return;
    }

    public void delete(int index) {
        DNode<T> dNode = getNode(index);
        dNode.next.pre = dNode.pre;
        dNode.pre.next = dNode.next;
        dNode = null;
        count--;
    }
}
