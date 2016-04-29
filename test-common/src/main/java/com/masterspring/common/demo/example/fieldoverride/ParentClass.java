package com.masterspring.common.demo.example.fieldoverride;

public class ParentClass {
    public int i = 30;

    private String privateField = "parent--privateField";

    String friendlyField = "parent--friendlyField";

    protected String protectedField = "parent--protectedField";

    public String publicField = "parent--publicField";


    public static String staticField = "静态变量-parent";

    public final String finalField = "常量-parent";

    public static final String staticfinalField = "静态常量-parent";

    public String getPrivateField() {
        return this.privateField;
    }
}
