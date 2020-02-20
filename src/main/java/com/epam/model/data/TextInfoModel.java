package com.epam.model.data;

import com.epam.model.entity.TextInfoHolder;
import com.epam.model.service.TextFileService;

public class TextInfoModel implements BaseModel {
    private TextInfoHolder textInfoHolder;

    @Override
    public TextInfoHolder getInstance() {
        if (textInfoHolder == null) {
            this.textInfoHolder = TextFileService.createInfoHolder();
        }
        return textInfoHolder;
    }

    @Override
    public int getParagraphCountInfo() {
        return getInstance().getParagraphCount();
    }

    @Override
    public int getSentenceCountInfo() {
        return getInstance().getSentenceCount();
    }

    @Override
    public int getWordCountInfo() {
        return getInstance().getWordCount();
    }

    @Override
    public int getSymbolCount() {
        return getInstance().getSymbolCount();
    }

    @Override
    public String getLongestWord() {
        return getInstance().getLongestWord();
    }

    @Override
    public char[] getSymbols() {
        return getInstance().getSymbols();
    }
}
