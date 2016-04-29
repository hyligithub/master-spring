package com.masterspring.common.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by lihuiyan on 2015/7/14.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UseCase {
    public int id();

    public String description() default "no description";
}
