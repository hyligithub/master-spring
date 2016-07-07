
package com.masterspring.common.juc.interrupt;

/**
 * Created by lihuiyan on 2015/4/28.
 */
public class Demo1 {
    public static void main(String[] args) {
        Thread thread = new MyThread("t1");
        System.out.println(thread.getName() + "--(" + thread.getState() + ")");
        thread.start();
        try {
            Thread.sleep(300);
            thread.interrupt();
            System.out.println(thread.getName() + "--" + thread.getState() + " is interrupted.");

            Thread.sleep(300);
            System.out.println(thread.getName() + "--" + thread.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}

class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }

    public void run() {
        try {
            int i = 0;
            while (!isInterrupted()) {
                Thread.sleep(100);
                i++;
                System.out.println(Thread.currentThread().getName() + "--(" + this.getState() + ") loop" + i);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "--(" + this.getState() + ") catch InterruptedException.");
        }
    }
};
