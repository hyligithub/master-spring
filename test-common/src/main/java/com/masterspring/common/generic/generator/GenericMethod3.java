package com.masterspring.common.generic.generator;


/**
 * Created by lihuiyan on 2016/3/18.
 */
public class GenericMethod3 {
    public static <T> T getX(T x) {
        return x;
    }

    public static void main(String[] args){
      String ss = getX("123");

    }
}
