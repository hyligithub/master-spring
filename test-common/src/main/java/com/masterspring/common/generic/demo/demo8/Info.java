package com.masterspring.common.generic.demo.demo8;

import com.masterspring.common.PrintUtil;
import com.masterspring.common.demo.testcallback.InterfaceA;

/**
 * Created by lihuiyan on 2016/7/12.
 * 泛型嵌套
 */
public class Info<T, V> {
    private T var;
    private V value;

    public Info(T var, V value) {
        this.setVar(var);
        this.setValue(value);
    }

    public T getVar() {
        return var;
    }

    public void setVar(T var) {
        this.var = var;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class Demo<S> {
    private S info;

    public Demo(S info) {
        this.setInfo(info);
    }

    public S getInfo() {
        return info;
    }

    public void setInfo(S info) {
        this.info = info;
    }
}

class DemoMain {
    public static void main(String[] args) {
        Demo<Info<String, Integer>> d = null;
        Info<String, Integer> i = null;
        i = new Info<String, Integer>("Tom", 20);
        d = new Demo<Info<String, Integer>>(i);
        PrintUtil.print(d.getInfo().getVar());
        PrintUtil.print(d.getInfo().getValue());
    }
}