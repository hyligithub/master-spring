package com.masterspring.common.com.mengdd.classloader;

public class Sample {

    public int v1 = 1;

    public Sample() {
        System.out.println("Sample is loaded by: "
                + this.getClass().getClassLoader().getParent());

        // 主动使用Dog类
        new Dog();
    }
}