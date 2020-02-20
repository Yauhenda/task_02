package com.epam.model.data;

import com.epam.model.entity.TextInfoHolder;

public interface BaseModel {
    TextInfoHolder getInstance();

    int getParagraphCountInfo();

    int getSentenceCountInfo();

    int getWordCountInfo();

    int getSymbolCount();

    String getLongestWord();

    char[] getSymbols();
}
