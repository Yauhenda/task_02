package dao;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements CompositeWord{
    private List<LeafWord> sentences;
    public static int sentencesCounter;

    public Paragraph(){
        this.sentences = new ArrayList<>();
        Paragraph.sentencesCounter++;
    }

    @Override
    public void add(LeafWord leaf) {
        sentences.add(leaf);
    }

    @Override
    public String getData() {
        StringBuilder res = new StringBuilder();
        for (LeafWord sentence : sentences) {
            res.append(sentence.getData().trim()).append(". ");
        }
        return res.toString().trim();
    }

    @Override
    public String toString() {
        return sentences + "";
    }

}
