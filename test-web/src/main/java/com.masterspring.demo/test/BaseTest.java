package com.masterspring.demo.test;

/**
 * Created by lihuiyan on 2016/3/8.
 */
public class BaseTest {
    public static  void main(String[] args){
        getHashCode("abc");
    }
    public static void getHashCode(String str){
        char[] chars = str.toCharArray();
        int hash = 0;
        for(int i = 0;i<str.length();i++){
            hash = chars[i]+31*hash;
        }
        System.out.println(hash);
    }
}
