package com.masterspring.common.demo.testcallback.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by lihuiyan on 2015/9/16.
 */
public class Local implements CallBack, Runnable {

    private Remote remote;

    public Local(Remote remote) {
        this.remote = remote;
    }

    public void execute() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("call back");
    }

    public void sendMessage() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        Local local = new Local(new Remote());
        local.sendMessage();
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    public void run() {
        remote.delBusiness(this);
    }
}
