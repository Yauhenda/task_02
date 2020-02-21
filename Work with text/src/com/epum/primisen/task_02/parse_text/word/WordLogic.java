package com.epum.primisen.task_02.parse_text.word;

import com.epum.primisen.task_02.parse_text.symbol.Symbol;
import com.epum.primisen.task_02.parse_text.utill.Regex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordLogic {

    public static List<Symbol> parse(String string) {

        Pattern pattern = Pattern.compile(Regex.SYMBOL.getRegex());
        Matcher matcher = pattern.matcher(string);

        int indexOfFirstElement = 0;

        List<Symbol> symbols = new ArrayList<>();
        while (matcher.find()) {
            symbols.add(new Symbol(matcher.group().charAt(indexOfFirstElement)));
        }

        return symbols;
    }
}
