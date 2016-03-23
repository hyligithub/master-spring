package com.masterspring.common.keyfinal;

/**
 * Created by lihuiyan on 2016/3/22.
 */
public class FinalMethdMain {
    public static void main(String[] args)
    {
        OverrideFinalMethod2 o2 = new OverrideFinalMethod2();
        o2.f();
        o2.g();
        OverrideFinalMethod o1 = new OverrideFinalMethod();

//        o1.f();
//        o1.g();

        FinalMethod f = o2;

    }
}
