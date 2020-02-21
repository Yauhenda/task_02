package by.epam.pronovich.task02.view;

import by.epam.pronovich.task02.controller.Controller;

public class View {

   private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void printText() {
    }

    public void printParagraphQuant() {
        System.out.println("Paragraphs: "+ controller.calcParagraphQuant());
    }

    public void printSentenceQuant() {
        System.out.println("Sentences: "+controller.calcSentenceQuant());
    }

    public void printWordQuant() {
        System.out.println("Words: "+controller.calcWordQuant());
    }

    public void printSymbolQuant() {
        System.out.println("Symbols: "+controller.calcSymbolQuant());
    }

    public void printLongestWord() {
        System.out.println("LongestWord: "+controller.findLongestWord());

    }
}
