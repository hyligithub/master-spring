package com.masterspring.common.test;

import com.masterspring.common.PrintUtil;
import org.junit.Assert;
import org.junit.Test;

public class AtUnitExample {
    public String methodOne() {
        return "this is method one";
    }

    @Test
    public void methodOneTest() {
        Assert.assertTrue(methodOne().equals("this is method one"));
        PrintUtil.print(methodOne());
    }
}