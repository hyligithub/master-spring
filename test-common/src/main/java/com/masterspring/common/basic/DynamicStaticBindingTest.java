package com.masterspring.common.basic;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/6/29.
 */
public class DynamicStaticBindingTest {

    void method(String str) {
        PrintUtil.print("this is method reloading(String str),str =" + str);
    }

    void method(Integer o) {
        PrintUtil.print("this is method reloading(Integer o),o=" + o);
    }

    public static void main(String[] args) {
        A a = new B();
        PrintUtil.print(a.x);
        PrintUtil.print(a.getX());
        a.doSomething();
        DynamicStaticBindingTest dd = new DynamicStaticBindingTest();
        dd.method(123);
        dd.method("hello world");
    }
}

class A {
    int x = 5;

    public int getX() {
        return x;
    }

    public void doSomething() {
        PrintUtil.print("this is class A");
    }
}

class B extends A {
    int x = 6;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void doSomething() {
        PrintUtil.print("this is class B");
    }
}