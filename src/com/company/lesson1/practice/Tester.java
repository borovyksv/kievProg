package com.company.lesson1.practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by user-pc on 13.06.2016.
 */
public class Tester {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        new TextContainer().save("D:\\a.txt");
        Class<?> clazz = TextContainer.class;
        SaveTo typeAnnotation = null;
        if (clazz.isAnnotationPresent(SaveTo.class)) {
            typeAnnotation = clazz.getAnnotation(SaveTo.class);
        }
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                method.invoke(new TextContainer(), typeAnnotation.path());
            }
        }

    }
}
