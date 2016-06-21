package com.company.lesson1.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by user-pc on 13.06.2016.
 */
@SaveTo(path = "D:\\file.txt")
public class TextContainer {

    String string = "String";

    @Saver
    public void save(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(string);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
