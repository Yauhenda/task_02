package model;

import java.util.ArrayList;

public class Sentence implements Component<Sentence> {
    private final static String DELIMITER_FOR_WORDS = " ";

    private ArrayList<Component> words;


    public Sentence(String s) {
        this.words = readText(s, DELIMITER_FOR_WORDS);
        Counter.word=Counter.word+words.size();

    }


    @Override
    public ArrayList<Component> readText(String text, String delimiter) {
        ArrayList<Component> words = new ArrayList<>();
        String[] list = text.split(delimiter);
        for (String s : list) {
            words.add(new Word(s));
        }
        return words;
    }


    @Override
    public String writeText(Sentence sentence) {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Component component : words) {
            text.append(" ").append(component);
        }
        return text.toString();
    }

}