package com.masterspring.common.oom.tools;

import com.masterspring.common.PrintUtil;

import java.util.Map;

/**
 * Created by lihuiyan on 2016/8/4.
 */
public class MyTraceThread {

    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
            Thread thread = entry.getKey();
            StackTraceElement[] stack = entry.getValue();
            if (thread.equals(Thread.currentThread())) {
                PrintUtil.print("current Thread's name is:" + Thread.currentThread().getName());
                continue;
            }
            for (StackTraceElement ss : stack) {
                PrintUtil.print(ss.toString());
            }
        }
    }
}
