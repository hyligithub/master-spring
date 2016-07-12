package com.masterspring.common.generic.demo.demo4;


import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/7/12.
 * 接口泛型示例
 */
public interface Info<T> {
    public T getVar();
}

class InfoImpl<T> implements Info<T> {
    private T var;

    public InfoImpl(T var) {
        this.setVar(var);
    }

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return var;
    }
}

class InfoImpl2 implements Info<String> {
    private String var;

    public InfoImpl2(String var) {
        this.setVar(var);
    }

    @Override
    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }
}

class Demo1 {
    public static void main(String[] args) {
        Info<String> i1 = new InfoImpl<String>("Tom");
        Info i2 = new InfoImpl2("jack");
        PrintUtil.print(i1.getVar());
        PrintUtil.print(i2.getVar());
    }
}
