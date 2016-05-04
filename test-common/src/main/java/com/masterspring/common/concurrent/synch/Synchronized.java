package com.masterspring.common.concurrent.synch;

/**
 * Created by lihuiyan on 2016/5/4.
 */
public class Synchronized {
    public static void main(String[] args){
        synchronized (Synchronized.class){
        }
        m();
    }
    public static synchronized  void m(){}
}
