package com.masterspring.common.oom.tools;

import com.masterspring.common.PrintUtil;
import org.junit.internal.runners.statements.RunAfters;

/**
 * Created by lihuiyan on 2016/8/4.
 */
public class MyRunnable implements Runnable {
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        PrintUtil.print("this is a run");
    }
}
