package com.masterspring.common.demo.testcallback;

/**
 * Created by lihuiyan on 2016/6/8.
 */
public class CallBackTest {

    public static void main(String[] args){
        Li li = new Li();
        Wang wang = new Wang(li);
        wang.askQuestion("what is bat");
    }
}
