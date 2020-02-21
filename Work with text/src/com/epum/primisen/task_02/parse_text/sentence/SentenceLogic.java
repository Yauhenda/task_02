package com.epum.primisen.task_02.parse_text.sentence;

import com.epum.primisen.task_02.parse_text.utill.Regex;
import com.epum.primisen.task_02.parse_text.word.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceLogic {

    public static List<Word> parse(String string) {

        Pattern pattern = Pattern.compile(Regex.WORD.getRegex());
        Matcher matcher = pattern.matcher(string);

        List<Word> words = new ArrayList<>();

        while (matcher.find()) {
            words.add(new Word(matcher.group()));
        }

        return words;
    }
}
