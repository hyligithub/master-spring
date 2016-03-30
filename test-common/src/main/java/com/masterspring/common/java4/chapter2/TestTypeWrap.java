package com.masterspring.common.java4.chapter2;

import com.masterspring.common.PrintUtil;
import org.junit.Test;

/**
 * Created by lihuiyan on 2016/3/31.
 */
public class TestTypeWrap {
    @Test
    public void testTypeWrap() {
        boolean b = false;
        Boolean b1 = b;
        PrintUtil.print(b1);

        Integer i = 2;
        int j = i;
        PrintUtil.print(j);

        Long l = 0L;
        long aa = 0;
        long ll = l;
        ll = aa;
        PrintUtil.print(ll);

    }
}
