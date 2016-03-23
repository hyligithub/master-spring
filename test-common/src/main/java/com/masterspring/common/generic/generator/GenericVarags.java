package com.masterspring.common.generic.generator;

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

    public static void main(String[] args){
        List<String> list = makeList("ab".split(""));
        for(String s:list){
            System.out.println(s);
        }
    }
}
