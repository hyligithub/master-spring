package com.masterspring.common.concurrent.synch;

import com.masterspring.common.PrintUtil;
import com.masterspring.common.SleepUtils;
import com.masterspring.common.demo.juc.sleeptest.SleepLockTest;
import com.masterspring.common.demo.thread.ThreadState;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lihuiyan on 2016/5/4.
 */
public class WaitNotity {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread wait = new Thread(new Wait(), "wait");
        Thread notify = new Thread(new Notify(), "notify");
        wait.start();
        SleepUtils.second(1);
        notify.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    try {
                        PrintUtil.print(Thread.currentThread() + "flag is true.wait@ " +
                                new SimpleDateFormat("HH:mm:ss").format(new Date()));
                        lock.wait();
                    } catch (InterruptedException e) {

                    }
                }
                PrintUtil.print(Thread.currentThread() + "flag is false.wait@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                PrintUtil.print(Thread.currentThread() + " hold lock.notify@ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                lock.notifyAll();
                flag = false;
                SleepUtils.second(5);
            }
            synchronized (lock) {
                PrintUtil.print(Thread.currentThread() + " lock again.sleep@:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                SleepUtils.second(5);
            }
        }
    }
}
