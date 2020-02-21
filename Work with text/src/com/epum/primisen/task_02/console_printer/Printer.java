package com.epum.primisen.task_02.console_printer;

import com.epum.primisen.task_02.parse_text.symbol.Symbol;
import com.epum.primisen.task_02.parse_text.paragraph.Paragraph;
import com.epum.primisen.task_02.parse_text.sentence.Sentence;
import com.epum.primisen.task_02.parse_text.text.Text;
import com.epum.primisen.task_02.parse_text.word.Word;

public class Printer {

    public static void printText(Text text){
        System.out.println(text);
    }

    public static void printParagraph(Paragraph paragraph){
        System.out.println(paragraph);
    }

    public static void printSentence(Sentence sentence){
        System.out.println(sentence);
    }

    public static void printWord(Word word){
        System.out.println(word);
    }

    public static void printSymbol(Symbol symbol){
        System.out.println(symbol);
    }
}
