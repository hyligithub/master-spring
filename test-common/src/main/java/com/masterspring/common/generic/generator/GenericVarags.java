package com.masterspring.common.generic.generator;

import com.masterspring.common.PrintUtil;
import com.masterspring.common.demo.juc.priority.PriorityTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2016/3/18.
 */
public class GenericVarags {

    public static <T> List<T> makeList(T... args) {
        List<T> list = new ArrayList<T>();
        for (T t : args) {
            list.add(t);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = makeList("ab".split(""));
        for (String s : list) {
            System.out.println(s);
        }
        List<String> list1 = makeList("A", "B", "C");
        for (String s : list1) {
            PrintUtil.print(s);
        }
    }
}
