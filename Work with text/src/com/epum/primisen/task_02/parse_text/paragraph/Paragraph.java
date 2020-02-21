package com.epum.primisen.task_02.parse_text.paragraph;

import com.epum.primisen.task_02.parse_text.sentence.Sentence;

import java.util.List;

public class Paragraph {

    private List<Sentence> sentences;

    public Paragraph(String string) {
        sentences = ParagraphLogic.parse(string);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String fourSpace = "    ";
        sb.append(fourSpace);

        for (Sentence sentence : sentences) {
            sb.append(sentence);
        }

        return sb.toString();
    }
}
