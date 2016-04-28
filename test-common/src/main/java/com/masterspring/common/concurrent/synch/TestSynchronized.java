package com.masterspring.common.concurrent.synch;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/4/26.
 */
public class TestSynchronized implements Runnable {

    public static void main(String[] args) {
        TestSynchronized myThread = new TestSynchronized();
        Thread thread1 = new Thread(myThread, "A");
        Thread thread2 = new Thread(myThread, "B");
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                PrintUtil.print(i + "--" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
