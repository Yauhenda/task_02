package view;

import controller.TextReader;
import dao.Paragraph;
import dao.Sentence;
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

        printParagraph();
        printSentences();
        printWords();
    }

    public void printResult(TextReader textReader, TextService textService) throws IOException {
        textService.formatText(textReader.read("src\\fileMain.txt"));
        System.out.println(textService.print());
    }

    public void printParagraph() {
        System.out.println("Number of Paragraphs: " +
                (Text.paragraphsCounter - 1));
    }

    public void printSentences() {
        System.out.println("Number of Sentences: " +
                (Paragraph.sentencesCounter));
    }

    public void printWords() {
        System.out.println("Number of Words: " +
                (Sentence.wordsCounter - 1));
    }
}
