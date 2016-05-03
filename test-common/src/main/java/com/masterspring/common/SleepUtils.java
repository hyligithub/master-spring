package com.masterspring.common;

import java.util.concurrent.TimeUnit;

/**
 * Created by lihuiyan on 2016/5/3.
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {

        }
    }
}
