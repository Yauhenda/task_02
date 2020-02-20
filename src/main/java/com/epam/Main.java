package com.epam;

import com.epam.controller.Controller;
import com.epam.model.data.BaseModel;
import com.epam.model.data.TextInfoModel;
import com.epam.view.View;

public class Main {
    public static void main(String[] args) {
        BaseModel model = new TextInfoModel();
        Controller controller = new Controller(model);
        View view = new View(controller);

       view.printText();
       view.printParagraphCountInfo();
       view.printSentenceCountInfo();
       view.printLongestWord();
       view.printWordCountInfo();
       view.printSymbolCount();
    }
}
