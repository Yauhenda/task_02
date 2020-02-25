package service.parser;

import dao.LeafWord;
import dao.Word;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractParser{
    public static final String WORD_VALIDATION = "[\\w]+";

    @Override
    public LeafWord parseLine(String string) {
        StringBuilder previousChar = new StringBuilder();
        StringBuilder nextChar = new StringBuilder();
        String stringWord = "";

        Pattern pattern = Pattern.compile(WORD_VALIDATION);
        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            if (start != 0) {
                previousChar.append(string.charAt(start - 1));
            }
            if (end != string.length() && !String.valueOf(string.charAt(end)).equals(".")) {
                nextChar.append(string.charAt(end));
            }
            stringWord = string.substring(start, end);
        }
        return new Word(stringWord, previousChar.toString(), nextChar.toString());
    }

}
