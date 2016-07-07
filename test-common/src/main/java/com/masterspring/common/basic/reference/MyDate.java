package com.masterspring.common.basic.reference;

import com.masterspring.common.PrintUtil;

import java.util.Date;

/**
 * Created by lihuiyan on 2016/6/29.
 */
public class MyDate extends Date {

    public MyDate() {

    }

    @Override
    protected void finalize() {
        PrintUtil.print("obj[Date:" + this.getTime() + "] is gc");
    }

    @Override
    public String toString() {
        return "Date:" + this.getTime();
    }
}
