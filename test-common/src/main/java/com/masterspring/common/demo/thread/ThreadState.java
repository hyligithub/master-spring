package com.masterspring.common.demo.thread;

import com.masterspring.common.SleepUtils;

/**
 * Created by lihuiyan on 2016/5/3.
 */
public class ThreadState {

    public static void main(String[] args) {
        new Thread(new TimeWaiting(),"time-waiting").start();
        new Thread(new Waiting(),"waiting").start();
        new Thread(new Blocked(),"blocked1").start();
        new Thread(new Blocked(),"blocked2").start();
    }

    static class TimeWaiting implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    static class Waiting implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (Waiting.class) {
                    try {
                        Waiting.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Blocked implements Runnable {

        @Override
        public void run() {
            while (true) {
                synchronized (Blocked.class) {
                    SleepUtils.second(100);
                }
            }
        }
    }
}
