package com.masterspring.common.keyfinal;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/3/22.
 */
public class OverrideFinalMethod extends FinalMethod {

    private final void f() {
        PrintUtil.print("overrideFinalMethod.f()");
    }

    private void g() {
        PrintUtil.print("overrideFinalMethod.g()");
    }
}
