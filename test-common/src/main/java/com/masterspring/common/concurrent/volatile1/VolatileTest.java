package com.masterspring.common.concurrent.volatile1;

import com.masterspring.common.PrintUtil;
import org.junit.Test;

import java.util.Random;

/**
 * Created by lihuiyan on 2016/4/1.
 */
public class VolatileTest {

    public volatile boolean status = false;

    @Test
    public void testStatus() {

        while (!status) {
            PrintUtil.print(status);
        }
    }

    class MyThread implements Runnable {

        @Override
        public void run() {
            status = true;
        }
    }

    @Test
    public void testMain() {
        new Thread(new MyThread()).start();
        testStatus();
    }

    public static void main(String[] args) {
        Random random = new Random(47);
        PrintUtil.print(random.nextInt(10));
    }
}
