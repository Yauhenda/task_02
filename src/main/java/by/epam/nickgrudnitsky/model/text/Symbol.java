package by.epam.nickgrudnitsky.model.text;

public class Symbol extends TextComponent {
    private char symbol;

    public Symbol(String symbol) {
        this.symbol = symbol.charAt(0);
        textComponentName = "SYMBOL";
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

    @Override
    public String getLongestWord() {
        return "";
    }

    @Override
    int getTextComponentCount(String textComponentName) {
        if (this.textComponentName.equalsIgnoreCase(textComponentName)){
            return 1;
        }
        return 0;
    }
}
