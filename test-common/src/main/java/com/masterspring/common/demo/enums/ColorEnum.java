package com.masterspring.common.demo.enums;

/**
 * Created by lihuiyan on 2015/11/25.
 */
public enum ColorEnum{
    Red("RED"),
    Yellow("YELLOW"),
    Green("GREEN");
    private final String color;

    private ColorEnum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

