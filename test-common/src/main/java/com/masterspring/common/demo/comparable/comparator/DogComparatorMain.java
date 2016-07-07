package com.masterspring.common.demo.comparable.comparator;

import com.masterspring.common.PrintUtil;

import java.util.TreeSet;

/**
 * Created by lihuiyan on 2016/6/21.
 */
public class DogComparatorMain {
    public static void main(String[] args) {
        TreeSet<Dog> treeSet = new TreeSet<Dog>(new DogComparator());
        treeSet.add(new Dog(2));
        treeSet.add(new Dog(1));
        treeSet.add(new Dog(1));

        for (Dog dog : treeSet) {
            PrintUtil.print(dog
                    .size);
        }
    }
}
