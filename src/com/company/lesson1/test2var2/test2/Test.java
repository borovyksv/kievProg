package com.company.lesson1.test2var2.test2;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by user-pc on 13.06.2016.
 */
public class Test implements Externalizable {
    @Save
    String s = "TESTING";
    @Save
    int a = 1;
    @Save
    double b = 5.0;
    @Save
    int c = 7;
    @Save
    int d = 9;
    int noSerialize1 = 999;
    int noSerialize2 = 9998;
    int noSerialize3 = 9999;
    int noSerialize4 = 9990;
    public Test() {
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\data.tmp"))) {
            outputStream.writeObject(test);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //load cat from file
        Object object = null;
        try (ObjectInputStream objectStream = new ObjectInputStream(new FileInputStream("D:\\data.tmp"))) {
            object = objectStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        Test newTest = (Test) object;

        System.out.println(newTest);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        Test test = new Test();
        Class clazz = test.getClass();
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                try {
                    out.writeObject(field.get(test));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Test test = new Test();
        Class clazz = test.getClass();
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                try {
                    field.set(test, in.readObject());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public String toString() {
        return "Test{" +
                "s='" + s + '\'' +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", noSerialize1=" + noSerialize1 +
                ", noSerialize2=" + noSerialize2 +
                ", noSerialize3=" + noSerialize3 +
                ", noSerialize4=" + noSerialize4 +
                '}';
    }
}
