package com.masterspring.common.generic.demo.demo6;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/7/12.
 * 通过泛型方法返回泛型实例
 */
public class Info<T extends Number> {
    private T var;

    public String toString() {
        return var.toString();
    }

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return var;
    }
}

class Demo1 {
    public static void main(String[] args) {
        Info<Integer> i = fun(30);//类型参数是整型，因此返回的泛型实例中的类型参数是整型
        PrintUtil.print(i.getVar());
    }

    public static <T extends Number> Info<T> fun(T temp) {//方法中传入或者返回的类型由调用时传入的参数类型决定
        Info<T> i1 = new Info<T>();//根据传入的类型实例化info
        i1.setVar(temp);//将传入的泛型类型设置到info 的属性中
        return i1;//返回info实例
    }
}

