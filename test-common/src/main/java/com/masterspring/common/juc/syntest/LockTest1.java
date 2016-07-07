package com.masterspring.common.juc.syntest;

/**
 * Created by lihuiyan on 2015/4/28.
 *
 ��һ��: ��һ���̷߳��ʡ�ĳ���󡱵ġ�synchronized���������ߡ�synchronized����顱ʱ�������̶߳ԡ��ö��󡱵ĸá�synchronized���������ߡ�synchronized����顱�ķ��ʽ���������
 �ڶ���: ��һ���̷߳��ʡ�ĳ���󡱵ġ�synchronized���������ߡ�synchronized����顱ʱ�������߳���Ȼ���Է��ʡ��ö��󡱵ķ�ͬ������顣
 ������: ��һ���̷߳��ʡ�ĳ���󡱵ġ�synchronized���������ߡ�synchronized����顱ʱ�������̶߳ԡ��ö��󡱵������ġ�synchronized���������ߡ�synchronized����顱�ķ��ʽ���������
 */
public class LockTest1 {
    Something x = new Something();
    Something y = new Something();
    // �Ƚ�(01) x.isSyncA()��x.isSyncB()
    private void test() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                x.isSynA();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                x.isSynB();
            }
        }, "t2");
        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        LockTest1 lockTest1 = new LockTest1();
        lockTest1.test();
    }
}

class Something {
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