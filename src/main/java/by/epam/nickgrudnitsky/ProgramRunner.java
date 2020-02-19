package by.epam.nickgrudnitsky;

import by.epam.nickgrudnitsky.model.output.ConsolePrinter;
import by.epam.nickgrudnitsky.service.TextService;

public class ProgramRunner {
    public static void main(String[] args) {
        TextService service = new TextService();

        service.readText("src/main/resources/myText.txt", new ConsolePrinter());
        service.printLongestWord();
        service.printParagraphCount();
        service.printSentenceCount();
        service.printWordCount();
        service.printSymbolCount();
        service.printText();
    }
}
