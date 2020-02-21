package model;

import java.util.ArrayList;

public class Word implements Component<Word> {
    private final static String DELIMITER_FOR_SYMBOL = "";

    private ArrayList<Component> letters;

    public Word(String s) {
        this.letters = readText(s, DELIMITER_FOR_SYMBOL);
        countSymbols();
        findLongWord();

    }

    private void findLongWord() {
        if(Counter.longWord.length()<letters.size()){
            StringBuilder sb= new StringBuilder();
            for(Component component: letters){
                sb.append(component);
            }
        Counter.longWord= String.valueOf(sb);
       }
    }

    private void countSymbols() {
        Counter.symbol= Counter.symbol+letters.size();
    }


    @Override
    public ArrayList<Component> readText(String text, String delimiter) {
        ArrayList<Component> words = new ArrayList<>();
        String[] list = text.split(delimiter);
        for (String s : list) {
            words.add(new Symbol(s));
        }
        return words;
    }

    @Override
    public String writeText(Word word) {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Component component : letters) {
            text.append(component);
        }
        return text.toString();
    }


}
