package com.masterspring.common.demo.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by lihuiyan on 2015/12/7.
 */
public class TestCase {
    public static void main(String[] args){
        MyClass myClass = new MyClass(1);
        myClass.increase(5);
//        System.out.println(myClass.getCount());

        try{
            Constructor constructor = MyClass.class.getConstructor(int.class);//获取构造函数
            MyClass myClass1 = (MyClass) constructor.newInstance(10);//获取对象实例
            Method method = myClass1.getClass().getMethod("increase",int.class);//获取方法
            method.invoke(myClass1,5);//方法调用
            Field field = myClass1.getClass().getDeclaredField("count");//获取域
            field.setAccessible(true);
            System.out.println(field.get(myClass1));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
