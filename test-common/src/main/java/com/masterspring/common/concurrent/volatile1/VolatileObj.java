package com.masterspring.common.concurrent.volatile1;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/4/1.
 */
public class VolatileObj {
    private String name = "volatile obj";

    public VolatileObj() {
        PrintUtil.print("construct volatileObj");
    }

    public String getName() {
        return name;
    }
}
