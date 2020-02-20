package com.epam.model;

import com.epam.model.entity.TextInfoHolder;

interface BaseModel {

    TextInfoHolder getInstance();

    int getParagraphCountInfo();

    int getSentenceCountInfo();

    int getWordCountInfo();

    int getSymbolCount();

    String getLongestWord();

    char[] getSymbols();
}
