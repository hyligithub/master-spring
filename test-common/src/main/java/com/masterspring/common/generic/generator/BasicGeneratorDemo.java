package com.masterspring.common.generic.generator;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/6/7.
 */
public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<CountedObject> generator = BasicGenerator.create(CountedObject.class);
        PrintUtil.print(generator.next());
    }
}
