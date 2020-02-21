package dao;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements CompositeWord{

    public static int sentensesCounter;

    private List<LeafWord> sentenses;

    @Override
    public void add(LeafWord leaf) {
        sentenses.add( leaf);
    }

    public Paragraph(){
        this.sentenses = new ArrayList<>();
    }

    @Override
    public String getData() {
        StringBuilder res = new StringBuilder();
        for (LeafWord sentence : sentenses) {
            res.append(sentence.getData().trim()).append(". ");
            sentensesCounter++;
        }
        return res.toString().trim();
    }

    @Override
    public String toString() {
        return sentenses + "";
    }

}
