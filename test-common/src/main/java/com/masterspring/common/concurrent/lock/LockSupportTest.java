package com.masterspring.common.concurrent.lock;

import com.masterspring.common.PrintUtil;
import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by lihuiyan on 2016/4/7.
 */
public class LockSupportTest {

    public static void main(String[] args){
        LockSupport.park();
        PrintUtil.print("aa");
    }
    @Test
    public void testPark1(){
        Thread thread = Thread.currentThread();
        LockSupport.unpark(thread);
        LockSupport.park();
        PrintUtil.print("aa");
    }
}
