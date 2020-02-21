package com.epam.andrei_eremenko.task_02.two;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    static String path = "Text.txt";
    private static final String REGEX_WORD = "([\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*)";
    private static final String PAR = "(\\s{4}(.*\\n)(.+\\n)*(.+$)*)";

    public static void main(String[] args) {

        Component paragraphList = new Composite();
        Pattern patternParagraph = Pattern.compile(PAR);
        Matcher matcher1 = patternParagraph.matcher(readFile(path));

        String paragraph;
        while (matcher1.find()) {
            paragraph = matcher1.group();
            Component paragraphs = new Composite();
            parseSentences(paragraphs, paragraph);
            paragraphList.addElement(paragraphs);
        }

        new Calculator(paragraphList.toString());
    }

    static Component parseSentences(Component paragraphs, String paragraph) {

        Component sentences = new Composite();
        Pattern patternWords = Pattern.compile(REGEX_WORD);
        Matcher matcher = patternWords.matcher(paragraph);

        String word;
        Component words;
        while (matcher.find()) {
            word = matcher.group();
            words = new Composite();
            sentences.addElement(words);
            parseSymbols(words, word);
        }
        paragraphs.addElement(sentences);
        return paragraphs;
    }

    static Component parseSymbols(Component words, String word) {
        char[] arr = word.toCharArray();
        for (char c : arr) {
            words.addElement(new Leaf(c));
        }
        return words;
    }

    static String readFile(String path) {
        String text = "";
        try {
            FileInputStream inFile = new FileInputStream(path);
            byte[] str = new byte[inFile.available()];
            inFile.read(str);
            text = new String(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}