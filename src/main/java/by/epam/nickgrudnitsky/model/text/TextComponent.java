package by.epam.nickgrudnitsky.model.text;

import by.epam.nickgrudnitsky.util.Patterns;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class TextComponent {
    String textComponentName = "TEXT";
    List<TextComponent> text = new ArrayList<>();
    static Map<String, Pattern> patterns = new LinkedHashMap<>();
    static boolean expressionProcessed = false;

    static {
        patterns.put("PARAGRAPH", Pattern.compile(Patterns.PARAGRAPH, Pattern.DOTALL));
        patterns.put("SENTENCE", Pattern.compile(Patterns.SENTENCE, Pattern.DOTALL));
        patterns.put("WORD", Pattern.compile(Patterns.WORD, Pattern.DOTALL));
        patterns.put("SYMBOL", Pattern.compile(Patterns.SYMBOL, Pattern.DOTALL));
    }

    abstract public String getLongestWord();

    abstract int getTextComponentCount(String textComponentName);

    public int getParagraphCount(){
        return getTextComponentCount("Paragraph");
    }

    public int getSentenceCount(){
        return getTextComponentCount("Sentence");
    }

    public int getWordCount(){
        return getTextComponentCount("Word");
    }

    public int getSymbolCount(){
        return getTextComponentCount("Symbol");
    }


}
