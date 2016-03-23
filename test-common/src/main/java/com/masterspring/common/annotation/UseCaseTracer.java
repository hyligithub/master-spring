package com.masterspring.common.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lihuiyan on 2016/3/15.
 */
public class UseCaseTracer {

    public static void trackUseCases(List<Integer> useCases, Class<?> clazz) {
        for (Method m : clazz.getDeclaredMethods()) {
            UseCase useCase = m.getAnnotation(UseCase.class);
            if (useCase != null) {
                int id = useCase.id();
                String desc = useCase.description();
                useCases.remove(new Integer(useCase.id()));
                System.out.println("found usecase,id = " + id + ",description:" + desc);
            }
        }
        for (int i : useCases) {
            System.out.println("NOT found usecase,id = " + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> useCases = new ArrayList<Integer>();
        Collections.addAll(useCases, 47, 48, 49, 50);
        trackUseCases(useCases, PasswordUtils.class);
    }
}
