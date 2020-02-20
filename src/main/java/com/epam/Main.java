package com.epam;

public class Main {
    public static void main(String[] args) {
        StringBuilder stringBuilder = TextReader.readFileLineByLine("src/data.txt");
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.length());
        TextInfo textInfo=new TextInfo();
        textInfo.regularCount(stringBuilder.toString());
    }
}
