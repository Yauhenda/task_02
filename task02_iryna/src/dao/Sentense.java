package dao;

import java.util.ArrayList;
import java.util.List;

public class Sentense implements CompositeWord{
    public static int wordsCounter;
    private List<LeafWord> words;

    @Override
    public void add(LeafWord leaf) {
        words.add( leaf);
    }

    public Sentense(){
        this.words = new ArrayList<>();
    }

    @Override
    public String getData() {
        StringBuilder res = new StringBuilder();
        for (LeafWord word : words) {
            wordsCounter++;
            res.append(word.getData()).append(" ");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        return  words + "";
    }
}
