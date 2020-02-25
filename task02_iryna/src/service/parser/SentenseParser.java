package service.parser;

import dao.CompositeWord;
import dao.LeafWord;
import dao.Sentence;
import java.util.Arrays;
import java.util.List;

public class SentenseParser extends AbstractParser {

  private static final String SPLIT_WORDS = "\\s";

    @Override
    public LeafWord parseLine(String line) {
        List<String> stringWords = Arrays.asList(line.split(SPLIT_WORDS));
        CompositeWord sentense = new Sentence();
        stringWords.forEach( o -> {
            LeafWord leafWord = nextParse(o);
            sentense.add(leafWord);
        });
        return sentense;
    }
}
