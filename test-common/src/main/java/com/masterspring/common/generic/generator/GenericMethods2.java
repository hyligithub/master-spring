package com.masterspring.common.generic.generator;

/**
 * Created by lihuiyan on 2016/3/17.
 */
public class GenericMethods2 {
    public static <A,B,C> void f(A a,B b, C c){
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(c.getClass().getName());
    }
    public static void main(String[] args){
        f("",1,2.0D);
    }
}
