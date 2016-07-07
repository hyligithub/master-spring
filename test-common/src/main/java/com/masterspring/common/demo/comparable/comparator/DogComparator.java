package com.masterspring.common.demo.comparable.comparator;

import java.util.Comparator;

/**
 * Created by lihuiyan on 2016/6/21.
 */
public class DogComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        return o1.size - o2.size;
    }
}
