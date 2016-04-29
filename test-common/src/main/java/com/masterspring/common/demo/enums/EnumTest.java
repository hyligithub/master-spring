package com.masterspring.common.demo.enums;

public class EnumTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        test();
        testColorEnum();
    }
    public static void testColorEnum(){
        for(ColorEnum colorEnum:ColorEnum.values()){
            System.out.println(colorEnum+"==========>"+colorEnum.getColor());
        }
    }
    public static void test() {
        String aa = CacheEnum.BETTING.format("aa", "bb");
//	String ss = aa + String.format("%s:开始", "betting");
        System.out.println(aa.toString());
    }

}
