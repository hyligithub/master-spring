package com.masterspring.common.generic.demo.demo3;

import com.masterspring.common.PrintUtil;
import com.masterspring.common.arithmetic.com.link.DoubleLink;

/**
 * Created by lihuiyan on 2016/7/12.
 * 受限泛型示例
 */
public class Info<T> {
    private T var;

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }
    public String toString(){
        return var.toString();
    }
}
class Demo1{
    public static void main(String[] args){
        Info<Integer> i1 = new Info<Integer>();
        i1.setVar(111);
        Info<Double> i2 = new Info<Double>();
        i2.setVar(222.22D);
        Info<String> i3 = new Info<String>();
        i3.setVar("aaaa");
        fun(i1);
        fun(i2);
//        fun(i3);//error
    }

    public static void fun(Info<? extends Number> temp){
        PrintUtil.print(temp);
    }
}
class Demo2{
    public static void main(String[] args){
        Info<String> i1 = new Info<String>();
        i1.setVar("aaa");
        Info<Double> i2 = new Info<Double>();
        i2.setVar(222.22D);
        Info<Object> i3 = new Info<Object>();
        i3.setVar(new Object());
        fun(i1);
        fun(i3);
//        fun(i2);//error
    }

    public static void fun(Info<? super String> temp){
        PrintUtil.print(temp);
    }
}
