package dao;


public class Word implements LeafWord{
    private String previousElement = "";
    private String element;
    private String nextElement = "";

    public Word(String element, String previousElement,  String nextElement){
        this.element = element;
        this.nextElement = nextElement;
        this.previousElement = previousElement;
    }

    @Override
    public String getData() {
        return previousElement + element + nextElement;
    }

    @Override
    public String toString() {
        return previousElement + element + nextElement;
    }
}
