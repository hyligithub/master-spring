package com.masterspring.common.demo.reflection;

/**
 * Created by lihuiyan on 2015/12/7.
 */
public class MyClass {
    private int count;

    public MyClass(int count) {
        this.count = count;
    }

    public void increase(int step) {
        count += step;
    }

    public int getCount(){
        return count;
    }
}

