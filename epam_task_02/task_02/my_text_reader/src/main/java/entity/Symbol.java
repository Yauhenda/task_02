package main.java.entity;

import java.util.HashMap;
import java.util.Map;

public class Symbol implements TextComponent {
    private static TextComponent.TextType type = TextComponent.TextType.SYMBOL;
    private static Map<Character, Symbol> symbols;
    private char symbol;

    private Symbol(char symbol) {
        this.symbol = symbol;
    }

    public static Symbol valueOf(char c) {
        if (symbols == null) {
            symbols = new HashMap<>();
        }
        Symbol s = symbols.get(c);
        if (s == null) {
            s = new Symbol(c);
            symbols.put(c, s);
        }
        return s;
    }

    @Override
    public String printText() {
        return String.valueOf(symbol);
    }

    @Override
    public TextType getTextType() {
        return type;
    }

    @Override
    public String toString() {
        return "Symbol = " + symbol;
    }
}