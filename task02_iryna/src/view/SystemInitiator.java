package view;

import controller.TextReader;
import dao.Paragraph;
import dao.Sentense;
import dao.Text;
import service.TextService;

import java.io.IOException;

public class SystemInitiator {
    public SystemInitiator() {
        TextReader textReader = new TextReader();
        TextService textService = new TextService();

        try {
            printResult(textReader, textService);
        } catch (IOException e) {
            System.out.println("There's something wrong");
        }

        printPar();
        printSent();
        printWords();
    }

    public void printResult(TextReader textReader, TextService textService) throws IOException {
        textService.formatText(textReader.read("src\\fileMain.txt"));
        System.out.println(textService.print());
    }

    public void printPar() {
        System.out.println("Number of Paragraphs: " +
                (Text.paragraphsCounter - 1));
    }

    public void printSent() {
        System.out.println("Number of Sentenses: " +
                (Paragraph.sentensesCounter - 1));
    }

    public void printWords() {
        System.out.println("Number of Words: " +
                (Sentense.wordsCounter - 1));
    }
}