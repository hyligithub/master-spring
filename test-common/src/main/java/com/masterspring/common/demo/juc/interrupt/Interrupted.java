package com.masterspring.common.demo.juc.interrupt;

import com.masterspring.common.PrintUtil;
import com.masterspring.common.SleepUtils;

/**
 * Created by lihuiyan on 2016/5/3.
 */
public class Interrupted {
    public static void main(String[] args) {
        Thread sleepThread = new Thread(new SleepThread(), "sleepThread");
        sleepThread.setDaemon(true);
        Thread busyThread = new Thread(new BusyThread(), "busyThread");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();

        SleepUtils.second(5);

        sleepThread.interrupt();
        busyThread.interrupt();

        PrintUtil.print(sleepThread.isInterrupted());
        PrintUtil.print(busyThread.isInterrupted());

    }

    static class SleepThread implements Runnable {

        @Override
        public void run() {
            while (true) {
                SleepUtils.second(100);
            }
        }
    }

    static class BusyThread implements Runnable {

        @Override
        public void run() {
            while (true) {

            }
        }
    }
}
