package com.epam.view;

import com.epam.controller.Controller;

public class View {
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void printParagraphCountInfo() {
        int paragraphCount = controller.getParagraphCountInfo();
        print("Paragraph count", paragraphCount);
    }

    public void printSentenceCountInfo() {
        int sentenceCount = controller.getSentenceCountInfo();
        print("Sentence count", sentenceCount);
    }

    public void printWordCountInfo() {
        int wordCount = controller.getWordCountInfo();
        print("Word count", wordCount);
    }

    public void printSymbolCount() {
        int symbolCount = controller.getSymbolCount();
        print("Symbol count", symbolCount);
    }

    public void printLongestWord() {
        String longestWord = controller.getLongestWord();
        print("Longest word", longestWord);
    }

    public void printText() {
        char[] symbols = controller.getSymbols();
        print(symbols);
    }

    private void print(char[] chars){
        System.out.println(chars);
    }

    private void print(String resultDescription, int result) {
        String output = String.format("%s = %d", resultDescription, result);
        System.out.println(output);
    }

    private void print(String resultDescription, String result) {
        String output = String.format("%s = %s", resultDescription, result);
        System.out.println(output);
    }
}
