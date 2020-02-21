package model;

import java.util.List;

public class Symbol implements Component<Symbol> {

   private  String symbol;

    public Symbol(String s) {
        this.symbol=s;
    }
    @Override
    public String toString() {
        return symbol;
    }
     @Override
    public List<Component> readText(String text, String delimiter) {
        return null;
    }

    @Override
    public String writeText(Symbol symbol) {
        return null;
    }


}
