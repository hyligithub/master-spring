package com.masterspring.common.oom.gcsuanfa;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/7/28.
 * 可达性分析算法在进行对象回收时，在进行最终的GC时会分为两步：第一步是对可以回收的对象(与GC ROOTS 无关联)进行标记，
 * 第二步判断这些标记对象是否有必要执行finalize()方法，依据是是否覆盖finalize()方法或者jvm已经执行过finalize()
 * <p>
 * 对有必要执行的finalize()的对象会放入一个队列，虚拟机会开启一个低级别线程对该队列中的对象进行回收，这里是对象最后拯救
 * 自己的机会，就是在finalize()方法中关联某个对象，使自己不被回收，否则就会被GC
 * finalize()只会被执行一次
 */
public class FinalizeEscapeGc {
    public static FinalizeEscapeGc SAVE_OK = null;

    private static void isAlive() {
        PrintUtil.print("I am is alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        PrintUtil.print("finalize is executed");
        SAVE_OK = this;//成功逃脱
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_OK = new FinalizeEscapeGc();
        SAVE_OK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_OK != null) {
            SAVE_OK.isAlive();
        } else {
            PrintUtil.print("i am is dead");
        }

        SAVE_OK = new FinalizeEscapeGc();
        SAVE_OK = null;
        System.gc();
        if (SAVE_OK != null) {
            isAlive();
        } else {
            PrintUtil.print("i am is dead");
        }
    }

}
