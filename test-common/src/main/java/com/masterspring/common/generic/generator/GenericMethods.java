package com.masterspring.common.generic.generator;

/**
 * Created by lihuiyan on 2016/3/17.
 */
public class GenericMethods {

    public static <T> void f(T x){
        System.out.println(x.getClass().getName());
    }
    public static void main(String[] args){
        f("");
        f(1);
        f(false);
        f(1.4D);
        f(2.5F);
    }
}
