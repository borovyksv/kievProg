package com.company.lesson1.test1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by user-pc on 13.06.2016.
 */
public class TestClass {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Class clazz = TestClass.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getDeclaredAnnotation(Test.class);
                method.invoke(new TestClass(), test.a(), test.b());

            }
        }


    }

    @Test(a = 2, b = 5)
    public void test(int a, int b) {
        System.out.println(a + " " + b);
    }
}
