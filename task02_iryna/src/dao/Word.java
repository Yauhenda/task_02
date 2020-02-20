package dao;

import java.util.Objects;

public class Word implements LeafWord{
    private String previousElement = "";
    private String word;
    private String nextElement = "";

    public Word(String word, String previousElement,  String nextElement){
        this.word = word;
        this.nextElement = nextElement;
        this.previousElement = previousElement;
    }

    @Override
    public String getData() {
        return previousElement + word + nextElement;
    }

    @Override
    public String toString() {
        return previousElement +  word  + nextElement;
    }
}
