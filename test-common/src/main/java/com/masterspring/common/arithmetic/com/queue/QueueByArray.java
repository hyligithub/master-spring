package com.masterspring.common.arithmetic.com.queue;

/**
 * Created by lihuiyan on 2016/7/25.
 * 通过数组实现顺序队列
 */
public class QueueByArray {
    private int front = 0;//队首
    private int rear = 0;//队尾
    private String[] queueArray;

    public QueueByArray(int queSize) {
        if (queSize <= 0) {
            throw new RuntimeException("队列容量必须大于0");
        }
        queueArray = new String[queSize];
    }

    public void put(String s) {
        if (isFull()) {
            throw new RuntimeException("队列已经满了");
        } else {
            queueArray[rear] = s;
            rear = (rear + 1) % queueArray.length;
        }
    }

    public String pop() {
        String frontValue = null;
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            frontValue = queueArray[front];
            front = (front + 1) % queueArray.length;
        }
        return frontValue;
    }

    private boolean isFull() {
        return front == (rear + 1) % queueArray.length;
    }

    private boolean isEmpty() {
        return front == rear;
    }
}
