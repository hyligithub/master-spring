package com.masterspring.common.concurrent.atomic;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/3/31.
 */
public class RecordingDemo {

    static int x = 0, y = 0, a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            x = y = a = b = 0;
            Thread one = new Thread() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            };
            Thread two = new Thread() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            };
            one.start();
            two.start();
            one.join();
            two.join();
            PrintUtil.print(x + "---" + y);
        }
    }
}
