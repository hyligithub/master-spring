package com.masterspring.common.arithmetic.com.queue;

/**
 * Created by lihuiyan on 2016/7/25.
 * 通过链表实现队列
 */
public class QueueByLinked {
    private QueueNode front = null;
    private QueueNode rear = null;

    public QueueByLinked() {

    }

    private class QueueNode {
        private String data;
        private QueueNode next;

        public QueueNode() {
            this.data = null;
            this.next = null;
        }
    }

    public void put(QueueNode inode) {
        if (isEmpty()) {
            front = rear = inode;
        } else {
            rear.next = inode;
            rear = inode;
        }
    }

    public QueueNode pop() {
        QueueNode frontNode = null;
        if (isEmpty())
            return null;
        else {
            frontNode = front;
            front = front.next;
            if (frontNode == rear)
                rear = null;
        }
        return frontNode;
    }

    private boolean isEmpty() {
        return front == null;
    }

}
