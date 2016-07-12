package com.masterspring.common.generic.demo.demo7;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/7/12.
 * 泛型数组
 */
public class InfoArray {
    public static void main(String[] args) {
        Integer i[] = fun1(1,2,3,4,5,6);//可变参数返回泛型数组实例
        fun2(i);
    }

    public static <T> T[] fun1(T... args) {
        return args;
    }

    public static <T> void fun2(T args[]) {
        for (T t : args) {
            PrintUtil.print(t);
        }
    }
}
