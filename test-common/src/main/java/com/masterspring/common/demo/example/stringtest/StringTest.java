package com.masterspring.common.demo.example.stringtest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihy
 *对于引号含文本的方式创建的String对象之间用"+"连接产生的新对象才会被加入到
 *字符串池；对于所有包含new方式新建对象(null)“+”连接表达式，所产生的新对象不会被加入到
 *字符串池
 *
 *运行结果：
String a ="ab";
String b ="cd";
d 被加入了字符串池
e 没有被加入了字符串池
f  沒有被加入了字符串池
g 沒有被加入了字符串池

 */
public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "ab";// 创建了一个对象，并加入到字符串池
		System.out.println("String a =\"ab\";");
		String b = "cd";// 创建了一个对象，并加入到字符串池
		System.out.println("String b =\"cd\";");

		String c = "abcd";

		String d = "ab" + "cd";

		if (d == c) {
			System.out.println("d 被加入了字符串池");
		} else {
			System.out.println("d 没有被加入字符串池中");
		}

		String e = a + "cd";

		if (e==c) {
			System.out.println("e 被加入了字符串池");
		} else {
			System.out.println("e 没有被加入了字符串池");
		}
		
		String f="ab"+b;
		if(f==c){
			System.out.println("f被加入了字符串池");
		}else{
			System.out.println("f  沒有被加入了字符串池");
		}
		String g=a+b;
		if(g==c){
			System.out.println("g 被加入了字符串池");
		}else{
			System.out.println("g 沒有被加入了字符串池");
		}
		
		String ss = getKey(new ArrayList());
		System.out.println(ss+"--------");
         
	}
	
	private static String getKey(List list) {
        StringBuffer strBuff = new StringBuffer();
        try {
            strBuff.append("aaa" + ".");
            if (list == null) {
                return strBuff.toString();
            }
            for (Object obj : list) {
                strBuff.append(obj.toString());
                strBuff.append("-");
            }
            strBuff.setLength(strBuff.length() - 1);
            return strBuff.toString();
        } finally {
            strBuff.setLength(0);
        }
    }

}
