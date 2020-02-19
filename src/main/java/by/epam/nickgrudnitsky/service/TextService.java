package by.epam.nickgrudnitsky.service;

import by.epam.nickgrudnitsky.model.output.Printer;
import by.epam.nickgrudnitsky.model.text.Text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextService {
    private Text text;
    private Printer printer;

    public void readText(String filePath, Printer printer){
        StringBuilder sb = new StringBuilder();
        this.printer = printer;

        try {
            Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(line -> sb.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        text = new Text(sb.toString());
    }

    public void printLongestWord(){
        printer.print("The longest word is " + text.getLongestWord() + "\n");
    }

    public void printText(){
        printer.print(text.toString());
    }

    public void printSymbolCount(){
        printer.print(String.format("The number of characters is %d\n", text.getSymbolCount()));
    }

    public void printSentenceCount(){
        printer.print(String.format("The number of sentences is %d\n", text.getSentenceCount()));
    }

    public void printWordCount(){
        printer.print(String.format("The number of words is %d\n", text.getWordCount()));
    }

    public void printParagraphCount(){
        printer.print(String.format("The number of paragraphs is %d\n", text.getParagraphCount()));
    }
}
