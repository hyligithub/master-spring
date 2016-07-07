package com.masterspring.common.oom;

/**
 * Created by lihuiyan on 2015/5/20.
 * VM args:-Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
//        javaVMStackSOF.stackLeakByThread();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable throwable) {
            System.out.println(javaVMStackSOF.stackLength);
            throw throwable;
        }
    }

    public void stackLeakByThread() {
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            }).start();
        }
    }

    private void dontStop() {
        while (true) {

        }
    }
}
