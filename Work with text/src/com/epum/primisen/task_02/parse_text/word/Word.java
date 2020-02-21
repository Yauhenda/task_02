package com.epum.primisen.task_02.parse_text.word;

import com.epum.primisen.task_02.parse_text.symbol.Symbol;

import java.util.List;

public class Word {

    private List<Symbol> symbols;

    public Word(String string) {

        symbols = WordLogic.parse(string);
    }

    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Symbol s : symbols) {
            sb.append(s);
        }
        return sb.toString();
    }
}
