package com.masterspring.common.keyfinal;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/3/22.
 */
public class OverrideFinalMethod2 extends OverrideFinalMethod {

    public final void f() {
        PrintUtil.print("OverrideFinalMethod2.f()");
    }

    public void g() {
        PrintUtil.print("overrideFinalMethod2.g()");
    }
}
