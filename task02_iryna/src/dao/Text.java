package dao;

import java.util.ArrayList;
import java.util.List;

public class Text implements CompositeWord{
    public static int paragraphsCounter;
    private List<LeafWord> paragraphs;

    @Override
    public void add(LeafWord leaf) {
        paragraphs.add(leaf);
        Text.paragraphsCounter++;
    }

    public Text(){
        this.paragraphs = new ArrayList<>();
    }

    @Override
    public String getData() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < paragraphs.size(); i++){
            if (i == 0) {
                res.append("\t").append(paragraphs.get(i).getData());
            } else res.append("\n" + "\t").append(paragraphs.get(i).getData());
        }
        return "\t" + res.toString().trim();
    }
}
