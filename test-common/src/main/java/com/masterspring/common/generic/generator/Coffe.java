package com.masterspring.common.generic.generator;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/3/17.
 */
public class Coffe {
    private static long counter = 0;
    private final long id = counter++;

    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }

    public static void main(String[] args){
        System.out.println((new Coffe()).toString());
        System.out.println((new Coffe()).toString());
        PrintUtil.print(counter);
    }
}
