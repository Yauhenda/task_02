package main.java.util;

import main.java.entity.Symbol;
import main.java.entity.TextComponent;
import main.java.entity.TextComposite;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static TextComponent parse(String string, TextComponent.TextType textType) {
        if (string.length() == 0) return null;
        if (string.length() == 1) {
            Symbol symbol = Symbol.valueOf(string.charAt(0));
            return symbol;
        }

        TextComposite textComposite = new TextComposite(textType);
        String[] split = string.split(textType.getRegexForSplit());
        for (String s : split) {
            TextComponent childComposite = parse(s, textType.getChild());
            textComposite.addTextComponent(childComposite);
        }
        return textComposite;
    }

    public static List<TextComponent> getParagraphs(TextComposite composite) {
        if (composite.getTextType().ordinal() > TextComponent.TextType.PARAGRAPH.ordinal())
            return null;

        if (composite.getTextType().equals(TextComponent.TextType.TEXT))
            return composite.getTextComponent();

        ArrayList<TextComponent> components = new ArrayList<>();
        components.add(composite);
        return components;
    }

    public static List<TextComponent> getSentences(TextComposite composite) {
        TextComponent.TextType sentenceType = TextComponent.TextType.SENTENCE;
        if (composite.getTextType().ordinal() > sentenceType.ordinal())
            return null;

        if (composite.getTextType().equals(sentenceType)) {
            ArrayList<TextComponent> textParts = new ArrayList<>();
            textParts.add(composite);
            return textParts;
        }

        List<TextComponent> paragraphs = getParagraphs(composite);
        List<TextComponent> sentences = new ArrayList<>();
        for (TextComponent p : paragraphs) {
            TextComposite paragraph = (TextComposite) p;
            sentences.addAll(paragraph.getTextComponent());
        }
        return sentences;
    }

    public static List<TextComponent> getWords(TextComposite composite) {
        TextComponent.TextType wordType = TextComponent.TextType.WORD;
        if (composite.getTextType().ordinal() > wordType.ordinal())
            return null;

        if (composite.getTextType().equals(wordType)) {
            ArrayList<TextComponent> textParts = new ArrayList<>();
            textParts.add(composite);
            return textParts;
        }

        List<TextComponent> sentences = getSentences(composite);
        List<TextComponent> words = new ArrayList<>();
        for (TextComponent sentence : sentences) {
            TextComposite s = (TextComposite) sentence;
            for (TextComponent wordOrSymbol : s.getTextComponent()) {
                if (wordOrSymbol.getTextType().equals(wordType)) words.add(wordOrSymbol);
            }
        }
        return words;
    }

    public static int getNumberOfParagraphs(TextComposite composite) {
        return getParagraphs(composite).size();
    }

    public static int getNumberOfSentences(TextComposite composite) {
        return getSentences(composite).size();
    }

    public static int getNumberOfWords(TextComposite composite) {
        return getWords(composite).size();
    }

    public static String getBiggestWordFromText(TextComposite composite) {
        List<TextComponent> words = getWords(composite);
        return "111";
    }
}