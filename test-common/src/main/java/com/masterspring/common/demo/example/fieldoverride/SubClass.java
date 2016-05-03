package com.masterspring.common.demo.example.fieldoverride;


/**
 * @author lihy
 * 
 * 变量的值取决于我们定义变量的类型，而不是对象的类型
 * 
 * 静态变量和常量属于类，而不属于对象
 * 
 * 
1. 由于private变量受访问权限的限制，它不能被覆盖。
2. 属性的值取父类还是子类并不取决于我们创建对象的类型，而是取决于我们定义的变量的类型。
3. friendly、protected和public修饰符并不影响属性的覆盖。
4. 静态变量和静态常量属于类，不属于对象，因此它们不能被覆盖。
5. 常量可以被覆盖。
6. 对于基本类型和对象，它们适用同样的覆盖规律。
 * 
 * 运行结果如下：
40
ParentClass parentClass = new ParentClass()
parent--privateField
parent--friendlyField
parent--protectedField
parent--publicField
ParentClass subClass = new SubClass()
subClass--privateField
parent--friendlyField
parent--protectedField
parent--publicField
subClaszz = new SubClass()
subClass--privateField
subClass--friendlyField
subClass--protectedField
subClass--publicField
静态变量
常量
静态常量
 *
 */
public class SubClass extends ParentClass {

	public int i = 10;

	private String privateField = "subClass--privateField";

	String friendlyField = "subClass--friendlyField";

	protected String protectedField = "subClass--protectedField";

	public String publicField = "subClass--publicField";

	public static String staticField = "静态变量";

	public final String finalField = "常量";

	public static final String staticfinalField = "静态常量";
	@Override
	public String getPrivateField() {
		return this.privateField;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ParentClass pClass = new SubClass();
//		SubClass sClass = new SubClass();
//		System.out.println(pClass.i + sClass.i);

//		ParentClass parentClass = new ParentClass();
//
//		System.out.println("ParentClass parentClass = new ParentClass()");
//
//		System.out.println(parentClass.getPrivateField());

//		System.out.println(parentClass.friendlyField);
//		System.out.println(parentClass.protectedField);
//		System.out.println(parentClass.publicField);
////
//		ParentClass subClass = new SubClass();
////
//		System.out.println("ParentClass subClass = new SubClass()");
//
//		System.out.println(subClass.getPrivateField());
////
//		System.out.println(subClass.friendlyField);
//		System.out.println(subClass.protectedField);
//		System.out.println(subClass.publicField);
//
//		SubClass subClaszz = new SubClass();
//
//		System.out.println("subClaszz = new SubClass()");
//
//		System.out.println(subClaszz.getPrivateField());
//
//		System.out.println(subClaszz.friendlyField);
//		System.out.println(subClaszz.protectedField);
//		System.out.println(subClaszz.publicField);
//
		SubClass s = new SubClass();
		System.out.println(SubClass.staticField);
		System.out.println(s.finalField);
		System.out.println(SubClass.staticfinalField);
	}

}
