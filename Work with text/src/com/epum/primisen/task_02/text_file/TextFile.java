package com.epum.primisen.task_02.text_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextFile {

    public static String read(String fileName) {

        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(fileName));

            try {
                String string;
                while ((string = bufferedReader.readLine()) != null) {
                    stringBuilder.append(string);
                }
            } finally {
                bufferedReader.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
