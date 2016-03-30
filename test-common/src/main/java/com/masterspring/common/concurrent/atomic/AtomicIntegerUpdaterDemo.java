package com.masterspring.common.concurrent.atomic;

import com.masterspring.common.PrintUtil;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * Created by lihuiyan on 2016/3/30.
 */
public class AtomicIntegerUpdaterDemo {

    class DemoData {
        public volatile int value1 = 1;
        volatile int value2 = 2;
        protected volatile int value3 = 3;
        private volatile int value4 = 4;
    }

    AtomicIntegerFieldUpdater<DemoData> getUpdater(String fieldName) {
        return AtomicIntegerFieldUpdater.newUpdater(DemoData.class, fieldName);
    }

    @Test
    public void doIt() {
        DemoData demoData = new DemoData();
        PrintUtil.print(getUpdater("value1").getAndSet(demoData, 10));
        PrintUtil.print(getUpdater("value2").incrementAndGet(demoData));
        //以下代码会抛异常,私有变量不允许反射访问
        PrintUtil.print(getUpdater("value3").decrementAndGet(demoData));
        PrintUtil.print(getUpdater("value4").compareAndSet(demoData, 4, 40));
    }


}
