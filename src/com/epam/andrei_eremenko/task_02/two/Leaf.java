package com.epam.andrei_eremenko.task_02.two;


public class Leaf implements Component {
    char symbol;

    public Leaf(String str) {
        this.symbol = str.charAt(0);
    }

    public Leaf(char c) {
        this.symbol = c;
    }

    @Override
    public void addElement(Component part) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize (){
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString(){
        return String.valueOf(symbol);
    }

    @Override
    public void print(){
        System.out.print(toString());
    }
}
