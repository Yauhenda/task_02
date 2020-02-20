package com.epam.model.entity;

public class TextInfoHolder {
    private int symbolCount;
    private int wordCount;
    private int sentenceCount;
    private int paragraphCount;
    private String longestWord;
    private char[] symbols;

    public TextInfoHolder(Builder builder) {
        this.symbolCount = builder.symbolCount;
        this.wordCount = builder.wordCount;
        this.sentenceCount = builder.sentenceCount;
        this.paragraphCount = builder.paragraphCount;
        this.longestWord = builder.longestWord;
        this.symbols = builder.symbols;
    }

    public int getSymbolCount() {
        return symbolCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public int getSentenceCount() {
        return sentenceCount;
    }

    public int getParagraphCount() {
        return paragraphCount;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public char[] getSymbols() {
        return symbols;
    }

    public static class Builder {
        private int symbolCount;
        private int wordCount;
        private int sentenceCount;
        private int paragraphCount;
        private String longestWord;
        private char[] symbols;

        public Builder setSymbolCount(int symbolCount) {
            this.symbolCount = symbolCount;
            return this;
        }

        public Builder setWordCount(int wordCount) {
            this.wordCount = wordCount;
            return this;
        }

        public Builder setSentenceCount(int sentenceCount) {
            this.sentenceCount = sentenceCount;
            return this;
        }

        public Builder setParagraphCount(int paragraphCount) {
            this.paragraphCount = paragraphCount;
            return this;
        }

        public Builder setLongestWord(String longestWord) {
            this.longestWord = longestWord;
            return this;
        }

        public Builder setSymbols(char[] symbols) {
            this.symbols = symbols;
            return this;
        }

        public TextInfoHolder build() {
            return new TextInfoHolder(this);
        }
    }
}
