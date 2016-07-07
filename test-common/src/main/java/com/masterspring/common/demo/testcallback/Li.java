package com.masterspring.common.demo.testcallback;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/6/8.
 */
public class Li {

    public void executeMessage(Wang wang, String question) {
        PrintUtil.print("wang's question:" + question);
        for (int i = 0; i < 1000; i++) {
            if (i == 500)
                PrintUtil.print("doing ....");
        }
        wang.solve("the answer is ..... i don't know");
    }
}
