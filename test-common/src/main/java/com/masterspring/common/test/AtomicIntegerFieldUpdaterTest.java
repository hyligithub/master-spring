package com.masterspring.common.test;

import com.masterspring.common.PrintUtil;
import com.masterspring.common.demo.juc.priority.PriorityTest;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;


/**
 * Created by lihuiyan on 2016/5/10.
 */
public class AtomicIntegerFieldUpdaterTest {

    class DataDemo {
        public volatile int value1 = 1;
        volatile int value2 = 2;
        protected volatile int value3 = 3;
        private volatile int value4 = 4;
    }

    AtomicIntegerFieldUpdater<DataDemo> getUpdater(String filedName) {
        return AtomicIntegerFieldUpdater.newUpdater(DataDemo.class, filedName);
    }
    @Test
    public void doIt(){
        DataDemo dataDemo = new DataDemo();
        PrintUtil.print(getUpdater("value1").incrementAndGet(dataDemo));
        PrintUtil.print(getUpdater("value2").addAndGet(dataDemo,10));
    }
}
