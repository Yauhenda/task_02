package service.parser;

import dao.CompositeWord;
import dao.LeafWord;
import dao.Paragraph;

import java.util.Arrays;
import java.util.List;

public class ParagraphParser extends AbstractParser {

    private static final String SENTENSE_SPLIT_REGEX = "[\\.][\\s]";

    @Override
    public LeafWord parseLine(String string) {
        List<String> stringSentences = Arrays.asList(string.split(SENTENSE_SPLIT_REGEX));
        CompositeWord paragraph = new Paragraph();
        stringSentences.forEach(o-> {
            LeafWord leafWord = nextParse(o);
            paragraph.add(leafWord);
        });
        return paragraph;
    }
}
