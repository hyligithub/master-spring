package com.masterspring.common.java4.chapter2;

import com.masterspring.common.PrintUtil;
import org.junit.Test;

/**
 * Created by lihuiyan on 2016/3/30.
 * static(静态变量和静态代码块按初始化顺序初始化) --> code block--> constructor
 *
 * 代码块属于对象实例，每new一个都会执行，static块属于类，只初始化一次
 */
public class TestStatic {
    static int i = 1;
    static int j;
    int m;

    static {
        PrintUtil.print("this is static block");
        j = 2;
        i=100;
    }

    {
        PrintUtil.print("this is code block");
        m = 10;
    }

    public TestStatic(){
        j++;
        i++;
    }


    public static void main(String[] args) {
        TestStatic t1 = new TestStatic();
//        t1.i = 2;

        TestStatic t2 = new TestStatic();
//        t2.i = 3;

        PrintUtil.print(TestStatic.i);
        PrintUtil.print(j);
        PrintUtil.print(t1.m);
    }
}
