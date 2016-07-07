package com.masterspring.common.generic.generator;

import com.masterspring.common.PrintUtil;
import com.masterspring.common.generic.TwoTuple;

/**
 * Created by lihuiyan on 2016/6/7.
 */
public class TupleTest {
    static TwoTuple<String, Integer> f() {
        return Tuple.tuple("aa", 123);
    }
    static TwoTuple f2(){
        return Tuple.tuple("bb",456);
    }

    public static void main(String[] args){
        PrintUtil.print(f2());
    }
}
