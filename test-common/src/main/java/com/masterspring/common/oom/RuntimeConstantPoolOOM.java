package com.masterspring.common.oom;

import com.masterspring.common.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lihuiyan on 2015/5/20.
 * VM args: -XX:PermSize10M -XX:MaxPermSize10M
 */
public class RuntimeConstantPoolOOM {


    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;

        while (true) {
            list.add(String.valueOf(i++).intern());
        }

//        String str1 = new StringBuffer("ja").append("va").toString();
//        String str2 = new StringBuffer("计算机").append("软件").toString();
//        PrintUtil.print(str1.intern() == str1);
//        PrintUtil.print(str2.intern() == str2);
    }
}
