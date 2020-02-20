package service;

import dao.CompositeWord;
import dao.Text;
import service.parser.ParagraphParser;
import service.parser.ParserChain;
import service.parser.SentenseParser;
import service.parser.TextParser;
import service.parser.WordParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextService {
    private static final String NEXT_LINE_SPLIT = ".{3,80}(?=\\s|\\Z)";
    private CompositeWord text;


    public void formatText(String stringText){
        ParserChain componentParser = new WordParser()
                .linkWith(new SentenseParser())
                .linkWith(new ParagraphParser())
                .linkWith(new TextParser());

        text = (Text) componentParser.parseLine(stringText);
    }

    public String print() {
        String stringText = text.getData();
        Pattern pattern = Pattern.compile(NEXT_LINE_SPLIT);
        Matcher matcher = pattern.matcher(stringText);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            String a = String.valueOf(stringText.charAt(start));
            if (a.equals(" ")) {
                result.append(stringText, start + 1, end).append("\n");
            } else result.append(stringText, start, end).append("\n");

        }
        if (String.valueOf(result.charAt(result.length() - 1)).equals("\n")){
            result = new StringBuilder(result.substring(0, result.length() - 1));
        }
        return result.toString();
    }
}
