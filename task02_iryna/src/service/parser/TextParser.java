package service.parser;

import dao.CompositeWord;
import dao.LeafWord;
import dao.Text;

import java.util.Arrays;
import java.util.List;

public class TextParser extends AbstractParser {

    private static final String PARAGRAPH_SPLIT_REGEX = "\t";

    @Override
    public LeafWord parseLine(String string) {
        List<String> stringParagraphs = Arrays.asList(string.split(PARAGRAPH_SPLIT_REGEX));
        CompositeWord text = new Text();
        stringParagraphs.forEach(o-> {
            LeafWord leafWord = nextParse(o);
            text.add(leafWord);
        });
        return text;
    }
}