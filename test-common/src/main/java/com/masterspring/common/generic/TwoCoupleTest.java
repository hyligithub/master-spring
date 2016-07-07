package com.masterspring.common.generic;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/6/5.
 */
public class TwoCoupleTest {
    public static void main(String[] args) {
        TwoTuple<String, Integer> test = f();
        PrintUtil.print(test.toString());
    }

    static TwoTuple<String, Integer> f() {
        return new TwoTuple<String, Integer>("aaa", 1111);
    }
}
