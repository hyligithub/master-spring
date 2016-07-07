package com.masterspring.common.juc.juclock.locktest;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lihuiyan on 2015/5/4.
 */
public class LockTest1 {

    public static void main(String[] args){
        Dept dept = new Dept();
        Producer producer = new Producer(dept);
        Consumer consumer = new Consumer(dept);
        producer.produce(60);
        producer.produce(120);
        consumer.consume(110);
        consumer.consume(80);
        producer.produce(100);
    }

}

class Dept {
    private int size;
    private Lock lock;

    public Dept() {
        this.size = 0;
        lock = new ReentrantLock();
    }

    public void producer(int val) {
        lock.lock();
        try {
            size += val;
            System.out.printf("%s produce(%d) --> size=%d\n",
                    Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();
        }
    }

    public void consumer(int val) {
        lock.lock();
        try {
            size -= val;
            System.out.printf("%s consumer(%d) --> size=%d\n",
                    Thread.currentThread().getName(), val, size);
        } finally {
            lock.unlock();
        }
    }
};

class Producer {
    private Dept dept;

    public Producer(Dept dept) {
        this.dept = dept;
    }

    public void produce(final int val) {
        new Thread(new Runnable() {
            public void run() {
                dept.producer(val);
            }
        }).start();
    }
};

class Consumer {
    private Dept dept;

    public Consumer(Dept dept) {
        this.dept = dept;
    }

    public void consume(final int val) {
        new Thread(new Runnable() {
            public void run() {
                dept.consumer(val);
            }
        }).start();
    }
};