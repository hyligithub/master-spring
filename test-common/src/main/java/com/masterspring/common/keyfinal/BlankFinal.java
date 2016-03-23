package com.masterspring.common.keyfinal;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/3/22.
 */
public class BlankFinal {
    private final int i = 0;//初始化final
    private final int j;//空final
    private final Poppet poppet;//空final引用

    //final必须要初始化，如果定义时没有初始化，必须在构造函数初始化
    public BlankFinal() {
        j = 1;
        poppet = new Poppet(10);
    }

    public BlankFinal(int x) {
        j = x;
        poppet = new Poppet(x);
    }

    public String toString() {
        return i + "--" + j + "[poppet]:" + poppet;
    }

    public static void main(String[] args) {
        BlankFinal b = new BlankFinal();

        BlankFinal b1 = new BlankFinal(1000);

        PrintUtil.print(b);
        PrintUtil.print(b1);
    }
}
