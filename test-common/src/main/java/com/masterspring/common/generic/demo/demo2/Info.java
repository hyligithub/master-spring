package com.masterspring.common.generic.demo.demo2;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/7/12.
 * 通配符泛型
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
        return this.var.toString();
    }
}

class Demo1 {
    public static void main(String[] args) {
        Info<String> info = new Info<String>();
        info.setVar("hello world");
        fun(info);
    }

    public static void fun(Info<?> temp) {//可以接受任意类型的泛型对象
        PrintUtil.print(temp);
    }
}
