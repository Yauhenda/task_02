package com.epum.primisen.task_02.parse_text.text;

import com.epum.primisen.task_02.parse_text.paragraph.Paragraph;

import java.util.List;

public class Text {

    private List<Paragraph> paragraphs;

    public Text(String string) {
        paragraphs = TextLogic.parse(string);
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (Paragraph paragraph : paragraphs) {
            stringBuilder.append(paragraph);
        }

        return stringBuilder.toString();
    }
}
