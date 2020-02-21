package com.epum.primisen.task_02.parse_text.sentence;

import com.epum.primisen.task_02.parse_text.word.Word;

import java.util.List;

public class Sentence {

    private List<Word> words;

    public Sentence(String string) {
        words = SentenceLogic.parse(string);
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Word word : words) {
            sb.append(word).append(" ");
        }
        String dot = ".";
        sb.append(dot);

        return sb.toString();
    }
}
