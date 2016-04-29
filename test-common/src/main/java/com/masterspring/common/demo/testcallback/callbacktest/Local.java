package com.masterspring.common.demo.testcallback.callbacktest;

/**
 * Created by lihuiyan on 2015/4/23.
 */
public class Local implements ICallBack, Runnable {

    private Remote remote;
    private String message;

    public Local(Remote remote, String message) {
        this.remote = remote;
        this.message = message;
    }

    public void execute(Object object) {
        System.out.println(object);
    }

    public void sendMessage(String message) {
        Thread thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Local local = new Local(new Remote(), "hello");
        local.sendMessage("begin send message");
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
        remote.callMe("hello", this);
    }
}
