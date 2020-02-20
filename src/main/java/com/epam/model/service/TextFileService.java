package com.epam.model.service;

import com.epam.model.entity.TextInfoHolder;

import java.io.*;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.model.entity.TextInfoHolder.Builder;

public class TextFileService {
    private final static String TEXT_FILE = "src/data.txt";
    private final static String SENTENCE_COUNT_REGEX = "[.]\\s";
    private final static String PARAGRAPH_COUNT_REGEX = "[\\s]{4}";
    private static Builder builder;
    private static StringBuilder text = new StringBuilder();
    private static char[] symbols;
    private static StringTokenizer words;

    public static TextInfoHolder createInfoHolder() {
        builder = new TextInfoHolder.Builder();
        try {
            text = readTextFile();
            initSymbolArray();
            initSymbolCount();
            initWordCount();
            findLongestWord();
            initSentenceCount();
            initParagraphCount();
            return new TextInfoHolder(builder);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            builder.setParagraphCount(0)
                    .setSentenceCount(0)
                    .setWordCount(0)
                    .setLongestWord("")
                    .setSymbolCount(0)
                    .setSymbols(new char[0])
                    .build();
            return new TextInfoHolder(builder);
        }
    }

    private static StringBuilder readTextFile() throws IOException {
        try (InputStream in = new FileInputStream(TEXT_FILE);
             Reader reader = new InputStreamReader(in)) {
            int c;
            while ((c = reader.read()) != -1) {
                text.append((char) c);
            }
        }
        return text;
    }

    private static void initSymbolArray() {
        symbols = new char[text.length()];
        text.getChars(0, symbols.length, symbols, 0);
        builder.setSymbols(symbols);
    }

    private static void initSymbolCount() {
        int symbol = 0;
        for (char character : symbols) {
            if (character != '\n' && character != ' ') {
                symbol++;
            }
        }
        builder.setSymbolCount(symbol);
    }

    private static void initWordCount() {
        words = new StringTokenizer(text.toString());
        int wordCount = words.countTokens();
        builder.setWordCount(wordCount);
    }

    private static void findLongestWord() {
        String longestWord = "";
        int maxWordLength = 0;
        while (words.hasMoreTokens()) {
            String word = words.nextToken();
            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
                longestWord = word;
            }
        }
        builder.setLongestWord(longestWord);
    }

    private static void initSentenceCount() {
        int sentenceCount = 0;
        Pattern pattern = Pattern.compile(SENTENCE_COUNT_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            sentenceCount++;
        }
        builder.setSentenceCount(sentenceCount);
    }

    private static void initParagraphCount() {
        int paragraphCount = 0;
        Pattern pattern = Pattern.compile(PARAGRAPH_COUNT_REGEX);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            paragraphCount++;
        }
        builder.setParagraphCount(paragraphCount);
    }
}
