package com.masterspring.common.generic.demo.demo5;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/7/12.
 * 泛型方法
 */
public class Info {
    public <T> T fun(T t) {//可以接受任意类型的参数
        return t;//直接返回参数
    }
}

class Demo1 {
    public static void main(String[] args) {
        Info i1 = new Info();
        String aa = i1.fun("aa");
        Integer bb = i1.fun(22);
        PrintUtil.print(aa);
        PrintUtil.print(bb);

    }
}
