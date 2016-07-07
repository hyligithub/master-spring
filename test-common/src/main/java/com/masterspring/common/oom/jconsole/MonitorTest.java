package com.masterspring.common.oom.jconsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lihuiyan on 2015/5/23.
 */
public class MonitorTest {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        br.readLine();
        createBusyThread();
//        br.readLine();
        Object object = new Object();
        testThreadWaitLock(object);
    }

    /**
     * �߳���ѭ��
     */
    public static void createBusyThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    ;
            }
        }, "testBusyThread").start();
    }

    /*
    �߳����ȴ�
     */
    public static void testThreadWaitLock(final Object lock) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testThreadWait").start();
    }
}
