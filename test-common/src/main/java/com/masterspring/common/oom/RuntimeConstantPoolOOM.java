package com.masterspring.common.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2015/5/20.
 * VM args: -XX:PermSize10M -XX:MaxPermSize10M
 */
public class RuntimeConstantPoolOOM {


    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        int i = 0;
//        while (true) {
//            list.add(String.valueOf(i++).intern());
//        }

//        String str1 = new StringBuffer("�����").append("���").toString();
//        System.out.println(str1.intern() == str1);

        String str2 = new StringBuffer("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
