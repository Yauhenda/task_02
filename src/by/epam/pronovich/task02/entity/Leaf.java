package by.epam.pronovich.task02.entity;

public class Leaf implements Component {

    private char symbol;

    public Leaf(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }

    @Override
    public int calcQuantity() {
        return 1;
    }

}
