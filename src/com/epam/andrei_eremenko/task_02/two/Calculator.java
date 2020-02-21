package com.epam.andrei_eremenko.task_02.two;

import java.util.*;

public class Calculator {
    List<String> wholeText;
    Set<String> croppedText;
    Iterator<String> iterator;
    int quantityWords;
    int occurrences;
    List<String> repeats;

    StringBuilder stringBuilder;

    String text;

    public Calculator(String text) {
        this.text = text;
        deleteParagraphs();
        splitTextToArray();
        dropText();
        countOverallWords();
        System.out.println(toString());
    }

    private void deleteParagraphs() {
        text = text.replaceAll("\n", " ");
    }

    private void splitTextToArray() {
        wholeText = new ArrayList<>(Arrays.asList(text
                .toLowerCase().trim().split("[[;:!?\".,\\] ]]+")));
    }

    private void dropText() {
        croppedText = new TreeSet<>(wholeText);
    }

    private void countOverallWords() {
        quantityWords = wholeText.size();
    }

    private String countWordsEntries() {
        iterator = croppedText.iterator();
        stringBuilder = new StringBuilder();

        while (iterator.hasNext()) {
            String current = iterator.next();
            occurrences = Collections.frequency(wholeText, current);
            stringBuilder
                    .append("Quantity of words: \"")
                    .append(current)
                    .append("\" -> ")
                    .append(occurrences)
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return "Text contains " + quantityWords + " words\n" +
                countWordsEntries();
    }
}
