package main.java;

import main.java.entity.TextComponent;
import main.java.entity.TextComposite;

import java.io.*;

public class Runner {
    public static void main(String[] args) {
        Reader reader;
        String textFromFile = null;
        try {
            reader = new BufferedReader(new FileReader("src/resource/text.txt"));
            StringBuffer stringBuffer = new StringBuffer();
            int i;
            while ((i = reader.read()) != -1) {
                stringBuffer.append((char) i);
            }
            textFromFile = stringBuffer.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextComposite textComposite = (TextComposite) main.java.util.Parser.parse(textFromFile, TextComponent.TextType.TEXT);
//        System.out.println(textComposite.toString());


    }
}