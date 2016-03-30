package com.masterspring.common.java4.chapter2;

import com.masterspring.common.PrintUtil;
import org.junit.Test;

/**
 * Created by lihuiyan on 2016/3/30.
 */
public class Test1 {
    private int i;
    private char c;

    @Test
    public void printlAll() {
        PrintUtil.print(i);
        PrintUtil.print(c);
    }
}
