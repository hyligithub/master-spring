package com.masterspring.common.generic;

/**
 * Created by lihuiyan on 2016/3/16.
 */
public class TwoTuple<A, B> {
    private final A first;
    private final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return first + "--" + second;
    }

    public static  void main(String[] args){
        TwoTuple<Integer,Integer> ss=new TwoTuple<>(1,2);
        System.out.println(ss);
    }
}
