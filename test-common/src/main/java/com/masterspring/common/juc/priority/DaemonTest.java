package com.masterspring.common.juc.priority;

/**
 * Created by lihuiyan on 2015/4/29.
 */
public class DaemonTest {
    public static void main(String[] args) {
        Thread t1 = new UserThread("t1");
        Thread t2 = new DaemonThread("t2");
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}

class UserThread extends Thread {
    public UserThread(String name) {
        super(name);
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(3);
                System.out.println(this.getName() + "---" + this.getPriority() + "---" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};

class DaemonThread extends Thread {
    public DaemonThread(String name) {
        super(name);
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(1);
                System.out.println(this.getName() +"---"+ this.getPriority() +"---"+ "loop");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
};
