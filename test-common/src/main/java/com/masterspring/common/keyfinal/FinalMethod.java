package com.masterspring.common.keyfinal;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/3/22.
 */
public class FinalMethod {
    private final void f() {
        PrintUtil.print("finalmethod.f()");
    }

    private void g() {
        PrintUtil.print("finalmethod.g()");
    }
}
