package com.masterspring.common.keyfinal;

import com.masterspring.common.PrintUtil;

import java.util.Random;

/**
 * Created by lihuiyan on 2016/3/21.
 */
public class FinalData {

    private static Random random = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    //编译期常量
    private final int valueOne = 9;

    private static final int VALUE_TWO = 99;

    //静态常量
    public static final int VALUE_THREE = 999;

    //不能在编译期初始化的常量
    private final int i4 = random.nextInt(20);
    static final int INT_5 = random.nextInt(20);

    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(33);

    //arrays
    private final int[] a = {1, 2, 3, 4};

    public String toString() {
        return id + ":" + "i4=" + i4 + ",INT_5=" + INT_5;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
//        fd1.valueOne++;//error
        fd1.v2.i++;
        fd1.v1 = new Value(9);

        //fd1.v2 = new Value(0);//error
//        fd1.VAL_3 = new Value(100);//error
//        fd1.a= new Value(222);//error
        PrintUtil.print(fd1);
        PrintUtil.print("Creating new FinalDATA");
        FinalData fd2 = new FinalData("fd2");
        PrintUtil.print(fd1);
        PrintUtil.print(fd2);
    }
}
