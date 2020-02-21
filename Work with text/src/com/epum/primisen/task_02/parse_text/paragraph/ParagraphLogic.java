package com.epum.primisen.task_02.parse_text.paragraph;

import com.epum.primisen.task_02.parse_text.sentence.Sentence;
import com.epum.primisen.task_02.parse_text.utill.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphLogic {

    public static List<Sentence> parse(String string) {

        Pattern pattern = Pattern.compile(Regex.SENTENCE.getRegex());
        Matcher matcher = pattern.matcher(string);

        List<Sentence> sentences = new ArrayList<>();

        while (matcher.find()) {
            sentences.add(new Sentence(matcher.group()));
        }

        return sentences;
    }
}
