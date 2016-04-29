package com.masterspring.common.demo.exception.puzzles;

/**
 * Created by lihuiyan on 2015/5/20.
 */
public class Test2 implements Type3 {
    public static void main(String[] args) {
        Type3 t3 = new Test2();
        t3.f();
    }

    public void f() {
        System.out.println("Hello world");
    }
}

interface Type1 {
    void f() throws CloneNotSupportedException;
}

interface Type2 {
    void f() throws InterruptedException;
}

interface Type3 extends Type1, Type2 {

}

