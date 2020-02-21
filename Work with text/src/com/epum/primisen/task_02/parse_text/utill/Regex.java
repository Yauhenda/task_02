package com.epum.primisen.task_02.parse_text.utill;

public enum Regex {

    PARAGRAPH("    "),
    SENTENCE("[\\w\\s]*[^.!?]"),
    WORD("\\w*[^\\s]"),
    SYMBOL("\\w");

    private String regex;

    Regex(String regex){
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }
}
