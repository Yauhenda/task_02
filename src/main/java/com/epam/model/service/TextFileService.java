package com.epam.data.service;

import com.epam.data.entity.TextInfoHolder;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.data.entity.TextInfoHolder.Builder;

public class TextFileService {
    private static final String TEXT_FILE = "src/data.txt";
    private static final String WORD_COUNT_REGEX = "\\s+";
    private static final String SENTENCE_COUNT_REGEX = "[.]{1}\\s";
    private static final String PARAGRAPH_COUNT_REGEX = "[^+\\s{4}][\\n+\\s{4}]";


    private static Builder builder;
    private static StringBuilder text;
    private static char[] symbols;
    private static String[] words;

    public static TextInfoHolder createInfoHolder() {
        readTextFile();
        initSymbolArray();
        initSymbolCount();
        initWordCount();
        initSentenceCount();
        initParagraphCount();
        return new TextInfoHolder(builder);
    }

    private static StringBuilder readTextFile() {
        text = new StringBuilder();
        try {
            try (InputStream in = new FileInputStream(TEXT_FILE);
                 Reader reader = new InputStreamReader(in)) {
                int c;
                while ((c = reader.read()) != -1) {
                    text.append((char) c);
                }
            }
            return text;
        } catch (IOException e) {
            e.printStackTrace();
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
        words = text.toString().split(WORD_COUNT_REGEX);
        int wordCount = words.length;
        builder.setWordCount(wordCount);
//        StringTokenizer tokens = new StringTokenizer(text.toString());
//        System.out.println(tokens.countTokens());
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
