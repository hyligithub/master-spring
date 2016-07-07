package com.masterspring.common.juc.producerconsumer;

/**
 * Created by lihuiyan on 2015/4/29.
 */
public class Depot {

    private int capacity;// ����
    private int size;//ʵ������

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public synchronized void producer(int num) {
        try {
            int left = num;//Ҫ����������
            while (left > 0) {
                while (size == capacity) {
                    wait();
                }
                int realNum = (left + size > capacity) ? (capacity - size) : left;//ʵ����������
                left -= realNum;
                size += realNum;
                System.out.printf("%s producer(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), num, left, realNum, size);
                notifyAll();
            }

        } catch (InterruptedException e) {

        }
    }

    public synchronized void consumer(int num) {
        try {
            int left = num;//Ҫ���ѵ�����
            while (left > 0) {
                while (size <= 0) {
                    wait();
                }
                int realNum = (left > size) ? size : left;//ʵ����������
                left -= realNum;
                size -= realNum;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), num, left, realNum, size);
                notifyAll();
            }
        } catch (InterruptedException e) {

        }
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
