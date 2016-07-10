package com.masterspring.common.classloadertest;

import com.masterspring.common.PrintUtil;
import com.masterspring.common.demo.innerclass.test.Price;

/**
 * Created by lihuiyan on 2016/7/10.
 */
public class TestClassLoader {

    public static void main(String[] args) {
        ClassLoader c = TestClassLoader.class.getClassLoader();
        PrintUtil.print(c);
        ClassLoader c1 = c.getParent();
        PrintUtil.print(c1);
        ClassLoader c2 = c1.getParent();
        PrintUtil.print(c2);
    }
}
