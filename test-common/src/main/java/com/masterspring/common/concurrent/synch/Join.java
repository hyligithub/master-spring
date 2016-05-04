package com.masterspring.common.concurrent.synch;

import com.masterspring.common.PrintUtil;
import com.masterspring.common.SleepUtils;

/**
 * Created by lihuiyan on 2016/5/4.
 */
public class Join {

    public static void main(String[] args) {
        Thread thread = new Thread(new Domino(Thread.currentThread()), "t1");
        thread.start();
        SleepUtils.second(5);
        PrintUtil.print(Thread.currentThread().getName() + " .terminate1");
    }

    static class Domino implements Runnable {
        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PrintUtil.print(Thread.currentThread().getName() + " .terminate");
        }
    }
}
