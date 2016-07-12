package com.masterspring.common.basic;

import com.masterspring.common.PrintUtil;

import java.util.Collection;
import java.util.List;

/**
 * Created by lihuiyan on 2016/7/11.
 * 测试可变参数
 * 可变参数只能放在最后
 */
public class Varable {
    public static void main(String[] args) {
        add(2, 3);
        add(2, 3, 4, 5);
    }

    public static void add(int x, int... args) {
        PrintUtil.print(x);
        for (int i : args) {
            PrintUtil.print(i);
        }
    }

    public void wildcard(Collection<Object> list){
        list.add(1);
    }
}
