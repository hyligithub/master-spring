package com.masterspring.common.generic.generator;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/6/6.
 */
public class GeneratorTest {
    private  static Class[] types = {Mocha.class, Breve.class, Latte.class};
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Coffe c = (Coffe)types[0].newInstance();
        PrintUtil.print(c);
    }
}
