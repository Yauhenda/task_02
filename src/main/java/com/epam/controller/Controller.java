package com.epam.controller;


import com.epam.model.data.BaseModel;

public class Controller {
    private BaseModel model;

    public Controller(BaseModel model) {
        this.model = model;
    }

    public int getParagraphCountInfo() {
        return model.getParagraphCountInfo();
    }

    public int getSentenceCountInfo() {
        return model.getSentenceCountInfo();
    }

    public int getWordCountInfo() {
        return model.getWordCountInfo();
    }

    public int getSymbolCount() {
        return model.getSymbolCount();
    }

    public String getLongestWord() {
        return model.getLongestWord();
    }

    public char[] getSymbols() {
        return model.getSymbols();
    }
}
