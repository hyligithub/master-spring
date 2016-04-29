package com.masterspring.common.demo.juc.juclock.locktest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lihuiyan on 2015/5/5.
 */
public class LockTest2 {
    public static void main(String[] args) {
        Dept1 dept1 = new Dept1(100);
        Producer1 producer1 = new Producer1(dept1);
        Consumer1 consumer1 = new Consumer1(dept1);
        producer1.produce(60);
        producer1.produce(110);
        producer1.produce(30);
        consumer1.consume(30);
        consumer1.consume(200);
        consumer1.consume(30);
        producer1.produce(100);
    }
}

class Producer1 {
    private Dept1 dept1;

    public Producer1(Dept1 dept1) {
        this.dept1 = dept1;
    }

    public void produce(final int val) {
        new Thread() {
            public void run() {
                dept1.produce(val);
            }
        }.start();
    }
};

class Consumer1 {
    private Dept1 dept1;

    public Consumer1(Dept1 dept1) {
        this.dept1 = dept1;
    }

    public void consume(final int val) {
        new Thread() {
            public void run() {
                dept1.consume(val);
            }
        }.start();
    }
};

class Dept1 {
    private int capacity;
    private int size;
    private Lock lock;
    private Condition fullCondition;
    private Condition emptyCondition;

    public Dept1(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }

    public void produce(int val) {
        lock.lock();
        try {
            int left = val;
            while (left > 0) {
                while (size >= capacity) {
                    fullCondition.await();
                }
                int inc = (size + left) > capacity ? (capacity - size) : left;
                size += inc;
                left -= inc;
                System.out.printf("%s produce(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, inc, size);
                emptyCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume(int val) {
        lock.lock();
        try {
            int left = val;
            while (left > 0) {
                while (size <= 0) {
                    emptyCondition.await();
                }
                int dec = left > size ? size : left;
                size -= dec;
                left -= dec;
                System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n",
                        Thread.currentThread().getName(), val, left, dec, size);
                fullCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
};
