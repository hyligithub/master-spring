package com.masterspring.common.arithmetic.com.queue;

/**
 * ����ʵ�ֶ���
 * ��Ӳ�����β
 * ���Բ�������ͷ
 * Created by lihuiyan on 2015/5/14.
 */
public class MyQueue {

    private int[] mArray;
    private int count;

    public MyQueue(int size) {
        mArray = new int[size];
        count = 0;
    }

    //���
    public void add(int val) {
        mArray[count++] = val;
    }

    //���ض���ͷ
    public int front() {
        return mArray[0];
    }

    public int pop() {
        int val = mArray[0];
        count--;
        for (int i = 1; i <= count; i++) {
            mArray[i - 1] = mArray[i];
        }
        return val;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(3);
        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        System.out.println(myQueue.size());

        System.out.println(myQueue.front());
//        System.out.println(myQueue.pop());
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.pop());
        }
    }
}
