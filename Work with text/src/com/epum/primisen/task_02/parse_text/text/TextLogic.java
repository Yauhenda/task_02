package com.epum.primisen.task_02.parse_text.text;

import com.epum.primisen.task_02.parse_text.paragraph.Paragraph;
import com.epum.primisen.task_02.parse_text.utill.Regex;

import java.util.ArrayList;
import java.util.List;

public class TextLogic {

    public static List<Paragraph> parse(String string) {

        List<Paragraph> paragraphs = new ArrayList<>();

        for (String s : string.split(Regex.PARAGRAPH.getRegex())) {
            paragraphs.add(new Paragraph(s));
        }

        return paragraphs;
    }
}
