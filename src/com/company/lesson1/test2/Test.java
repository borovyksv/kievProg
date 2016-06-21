package com.company.lesson1.test2;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by user-pc on 13.06.2016.
 */
public class Test implements Serializable {
    public static void main(String[] args) throws IllegalAccessException {
        //создаем экзепляр класса
        Test test = new Test();

        //достаем поля
        Field[] fields = Test.class.getDeclaredFields();

        //Counter для подсчета количества сеарилизованых обьектов
        int counter = 0;
        //List для результатов сериализации
        ArrayList<Object> afterSerialization = new ArrayList<>();

        //Сериализуем поля с аннотацией @Save
        for (Field field : fields) {
            if (field.isAnnotationPresent(Save.class)) {
                counter++;
                Object parameter = field.get(test);
                serialize(counter, parameter);
            }
        }
        //десериализация
        for (int i = 1; i <= counter; i++) {
            afterSerialization.add(deserialize(i));
        }
        //вывод в консоль
        System.out.println(afterSerialization);

    }

    private static void serialize(int counter, Object parameter) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(String.format("D:\\ser%d.tmp", counter)))) {
            out.writeObject(parameter);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Object deserialize(int counter) {
        Object result = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(String.format("D:\\ser%d.tmp", counter)))) {
            result = in.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }


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
}
