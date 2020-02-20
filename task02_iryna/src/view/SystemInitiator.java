package view;

import controller.TextReader;
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
    }

    public void printResult(TextReader textReader, TextService textService) throws IOException {
        textService.formatText(textReader.read("src\\fileMain.txt"));
        System.out.println(textService.print());
    }
}