package com.masterspring.common.generic;

/**
 * Created by lihuiyan on 2016/6/5.
 */
public class ThreeObject<A, B, C> extends TwoTuple<A, B> {
    public final C three;

    public ThreeObject(A first, B second, C three) {
        super(first, second);
        this.three = three;
    }
}
