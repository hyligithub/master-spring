package com.masterspring.common.generic.generator;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lihuiyan on 2016/6/7.
 */
public class Sets {
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> a = new HashSet<T>(set1);
        a.addAll(set2);
        return a;
    }

    public static <T> Set<T> diff(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<T>(a);
        result.removeAll(b);
        return result;
    }
}
