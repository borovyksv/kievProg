package com.company.lesson1.tast3;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by user-pc on 13.06.2016.
 */
public class Test implements Serializable {
    @Save
    private
    String s;
    @Save
    private int a;
    @Save
    private double b;
    @Save
    private int c;
    @Save
    private int d;
    private int noSerialize1;
    private int noSerialize2;
    private int noSerialize3;
    private int noSerialize4;
    public Test(String s, int a, double b, int c, int d, int noSerialize1, int noSerialize2, int noSerialize3, int noSerialize4) {
        this.s = s;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.noSerialize1 = noSerialize1;
        this.noSerialize2 = noSerialize2;
        this.noSerialize3 = noSerialize3;
        this.noSerialize4 = noSerialize4;
    }

    public static void main(String[] args) throws IllegalAccessException {
        //создаем экзепляр класса
        Test test = new Test("OldTestClass", 1, 5.0, 7, 9, 999, 9999, 9998, 9990);
        // @toString класса
        System.out.println(test);

        //достаем поля
        Field[] fields = Test.class.getDeclaredFields();

        //Фильтр полей с аннотацией @Save
        HashMap<String, Object> fieldMap = new HashMap<>();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                fieldMap.put(field.getName(), field.get(test));
            }
        }

        //сериализация полей
        serialize(fieldMap);

        //десериализация
        HashMap<String, Object> deserialized = (HashMap<String, Object>) deserialize();

        //создаем новый экземпляр класса
        Test newTest = new Test("NewTestClass", 200, 300.0, 700, 900, 100000, 1000000, 10000000, 1000000);


        //обновляем значения полей с десериализованой мапы
        Field[] newFields = newTest.getClass().getDeclaredFields();
        for (Field field : newFields) {
                if (deserialized.containsKey(field.getName())) {
                    field.set(newTest, deserialized.get(field.getName()));
                }
        }
        System.out.println(newTest);


    }

    private static void serialize(HashMap<String, Object> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:\\ser.tmp"))) {
            out.writeObject(list);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Object deserialize() {
        Object result = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:\\ser.tmp"))) {
            result = in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return result;
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
