package com.masterspring.common.demo.test;

/**
 * Created by lihuiyan on 2016/3/10.
 */
public class LoadClassDemo {
    public LoadClassDemo() {
        System.out.println("this is constructor block");
    }

    {
        System.out.println("this is code block");
    }
    static int b = 2;
    static {
        System.out.println("this is static block2");
        System.out.println(b);
    }
    static int a = 1;

    static {
        System.out.println("this is static block");
        System.out.println(a);
    }
    public static void main(String[] args) {
        System.out.println("this is is main");
        LoadClassDemo loadClassDemo = new LoadClassDemo();
        LoadClassDemo loadClassDemo1 = new LoadClassDemo();
    }
}
