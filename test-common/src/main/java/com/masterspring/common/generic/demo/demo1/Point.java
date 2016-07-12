package com.masterspring.common.generic.demo.demo1;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/7/12.
 * 普通泛型示例
 */
public class Point<T> {
    private T var;

    public void setVar(T value) {
        this.var = value;
    }

    public T getVar() {
        return var;
    }
}

class Demo1 {
    public static void main(String[] args) {
        Point<String> p = new Point<String>();
        p.setVar("hello world");
        PrintUtil.print(p.getVar().length());
    }
}
