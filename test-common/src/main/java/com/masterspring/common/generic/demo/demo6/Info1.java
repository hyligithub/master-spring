package com.masterspring.common.generic.demo.demo6;


import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/7/12.
 */
public class Info1<T> {
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

class Demo2 {
    public static void main(String[] args) {
        Info1<String> t1 = new Info1<String>();
        Info1<String> t2 = new Info1<String>();
        Info1<Integer> t3 = new Info1<Integer>();
        t1.setVar("Tom");
        t2.setVar("jack");
        add(t1, t2);
    }

    public static <T> void add(Info1<T> t1, Info1<T> t2) {
        PrintUtil.print(t1.getVar() + "" + t2.getVar());
    }

}
