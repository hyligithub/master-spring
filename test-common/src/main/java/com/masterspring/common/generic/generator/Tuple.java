package com.masterspring.common.generic.generator;

import com.masterspring.common.generic.TwoTuple;

/**
 * Created by lihuiyan on 2016/6/7.
 */
public class Tuple {
    static <A, B> TwoTuple<A, B> tuple(A a, B b) {
        return new TwoTuple<A, B>(a, b);
    }
}
