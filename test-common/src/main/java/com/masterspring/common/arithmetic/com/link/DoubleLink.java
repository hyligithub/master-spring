package com.masterspring.common.arithmetic.com.link;

/**
 * Created by lihuiyan on 2015/5/13.
 * 双向链表
 */
public class DoubleLink<T> {

    private DNode<T> mHead;//队列头，实际是傀儡节点
    private int count;//队列长度

    public DoubleLink() {
        mHead = new DNode<T>(null, null, null);//初始化头节点
        mHead.pre = mHead.next = mHead;
        count = 0;
    }

    private class DNode<T> {
        public DNode pre;
        public DNode next;
        public T value;

        public DNode(T t, DNode pre, DNode next) {
            value = t;
            this.pre = pre;
            this.next = next;
        }
    }

    ///队列长度
    public int size() {
        return count;
    }

    //判断是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    public DNode<T> getNode(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        //正向查找
        if (index < count / 2) {
            DNode<T> dNode = mHead.next;
            for (int i = 0; i < index; i++) {
                dNode = dNode.next;
            }
            return dNode;
        }

        //逆向查找
        DNode<T> rNode = mHead.pre;
        int rIndex = count - index - 1;
        for (int j = 0; j < rIndex; j++)
            rNode = rNode.pre;
        return rNode;
    }

    //获得index位置的节点
    public T getValue(int index) {
        return this.getNode(index).value;
    }

    //获得队列第一个节点
    public T getFirstValue() {
        return this.getValue(0);
    }

    //插入节点
    public void insert(int index, T t) {
        if (index == 0) {
            DNode<T> dNode = new DNode<T>(t, mHead, mHead.next);
            mHead.next.pre = dNode;
            mHead.next = dNode;
            count++;
            return;
        }

        DNode<T> dNode = this.getNode(index);
        DNode<T> node = new DNode<T>(t, dNode.pre, dNode);
        dNode.pre.next = node;
        dNode.pre = node;
        count++;
        return;
    }

    //插入首节点
    public void insertFirst(T t) {
        this.insert(0, t);
    }

    //队尾插入节点
    public void appendLast(T t) {
        DNode<T> node = new DNode<T>(t, mHead.pre, mHead);
        mHead.pre.next = node;
        mHead.pre = node;
        count++;
    }

    public void delete(int index) {
        DNode<T> node = getNode(index);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node = null;
        count--;
    }

    public void deletFirst() {
        this.delete(0);
    }

    public void deleteLast() {
        delete(count - 1);
    }
}
