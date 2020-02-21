package com.epum.primisen.task_02;

import com.epum.primisen.task_02.console_printer.Printer;
import com.epum.primisen.task_02.parse_text.text.Text;
import com.epum.primisen.task_02.text_file.TextFile;

public class Main {

    public static void main(String[] args) {
        String textForParse = TextFile.read("text.txt");

        Text text = new Text(textForParse);

        Printer.printText(text);
    }
}
