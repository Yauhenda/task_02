package model;


import java.util.ArrayList;

public class Text implements Component<Text> {

    private final static String DELIMITER_FOR_PARAGRAPH = "\n    ";

    private ArrayList<Component> paragraphs;

    public Text(String text) {
        this.paragraphs = readText(text, DELIMITER_FOR_PARAGRAPH);
        countParagraphs();
    }

    private void countParagraphs() {
        Counter.paragraph = paragraphs.size();
    }

    @Override
    public ArrayList<Component> readText(String text, String delimiter) {
        ArrayList<Component> paragraphs = new ArrayList<>();
        String[] list = text.split(delimiter);
        for (String s : list) {
            paragraphs.add(new Paragraph(s));
        }

        return paragraphs;
    }

    @Override
    public String writeText(Text text) {
        return toString();
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder();
       for (Component component : paragraphs) {
            text.append(DELIMITER_FOR_PARAGRAPH).append(component);
        }
        return text.toString();
    }
}
