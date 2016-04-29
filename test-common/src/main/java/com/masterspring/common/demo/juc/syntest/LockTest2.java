package com.masterspring.common.demo.juc.syntest;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class LockTest2 {
    Something1 x = new Something1();
    Something1 y = new Something1();

    // �Ƚ�(01) x.isSyncA()��x.isSyncB()
    private void test() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                x.isSynA();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                y.isSynB();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        LockTest2 lockTest2 = new LockTest2();
        lockTest2.test();
    }
}

class Something1 {
    public synchronized void isSynA() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " isSynA");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void isSynB() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " isSynB");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
};
