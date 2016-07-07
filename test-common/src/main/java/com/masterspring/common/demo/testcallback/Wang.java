package com.masterspring.common.demo.testcallback;

import com.masterspring.common.PrintUtil;

/**
 * Created by lihuiyan on 2016/6/8.
 */
public class Wang implements ICallBack {
    private Li li;

    public Wang(Li li) {
        this.li = li;
    }

    public void askQuestion(final String question) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.executeMessage(Wang.this, question);
            }
        }).start();
    }

    @Override
    public void solve(String result) {
        PrintUtil.print("xiao Li's answer is : " + result);
    }


}
