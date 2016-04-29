package com.masterspring.common.demo.example.paramtest;

/**
 * @author lihy
 * 
1. 对于基本类型，在方法体内对方法参数进行重新赋值，并不会改变原有变量的值。
2. 对于引用类型，在方法体内对方法参数进行重新赋予引用，并不会改变原有变量所持有的引用。
3. 方法体内对参数进行运算，不影响原有变量的值。
4. 方法体内对参数所指向对象的属性进行运算，将改变原有变量所指向对象的属性值
 *
 */
public class ParamTest {

	protected int num = 0;

	public void change(int i) {
		i = 5;
	}

	public void change(ParamTest t) {
		ParamTest tmp = new ParamTest();
		tmp.num = 9;
		t = tmp;
	}

	public void add(int i) {
		i += 10;
	}

	public void add(ParamTest pt) {
		pt.num += 20;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParamTest pt = new ParamTest();

//		System.out.println("参数--基本类型");
//
//		System.out.println("原有的值：=" + pt.num);
//
//		pt.change(pt.num);
//
//		System.out.println("赋值之后：=" + pt.num);
//
//		pt.change(pt);
//
//		System.out.println("运算之后:=" + pt.num);

		pt = new ParamTest();
		System.out.println("参数--引用类型");
		System.out.println("原有的值：=" + pt.num);
		pt.add(pt.num);
		System.out.println("赋引用之后：=" + pt.num);
//
//		pt.add(pt);
//
//		System.out.println("改属性之后：=" + pt.num);
	}

}
