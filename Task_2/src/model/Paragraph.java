package model;

import java.util.ArrayList;


public class Paragraph implements Component<Paragraph> {

    private final static String DELIMITER_FOR_SENTENCE = "\\. ";

    private ArrayList<Component> sentences;

    public Paragraph(String s) {
        this.sentences = readText(s, DELIMITER_FOR_SENTENCE);
        Counter.sentence = Counter.sentence + sentences.size();
    }


    @Override
    public ArrayList<Component> readText(String text, String delimiter) {
        ArrayList<Component> sentences = new ArrayList<>();

        String[] list = text.split(delimiter);
        for (String s : list) {
            sentences.add(new Sentence(s));
        }


        return sentences;
    }


    @Override
    public String writeText(Paragraph paragraph) {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
        for (Component component : sentences) {
                text.append(component).append(".");
        }

        return text.toString();
    }
}
