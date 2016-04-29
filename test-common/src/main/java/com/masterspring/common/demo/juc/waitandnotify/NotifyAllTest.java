package com.masterspring.common.demo.juc.waitandnotify;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class NotifyAllTest {

    public static void main(String[] args) {
        new NotifyAllTest().test();
    }

    public void test() {
        Object object = new Object();
        Thread_1 thread1 = new Thread_1("thread1", object);
        Thread_1 thread2 = new Thread_1("thread2", object);
        Thread_1 thread3 = new Thread_1("thread3", object);
        thread1.start();
        thread2.start();
        thread3.start();
        try {
            System.out.println(Thread.currentThread().getName() + " sleep 3000 ms");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (object) {
            System.out.println(Thread.currentThread().getName() + " notifyALL");
            object.notifyAll();
        }

    }
}

class Thread_1 extends Thread {
    private Object object;

    public Thread_1(String name, Object object) {
        super(name);
        this.object = object;
    }

    public void run() {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + " wait");
                object.wait();
                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
};