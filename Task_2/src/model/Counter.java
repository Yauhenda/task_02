package model;

public class Counter {
    static int paragraph = 0;
    static int sentence = 0;
    static int word = 0;
    static int symbol = 0;
    static String longWord = "";

    @Override
    public String toString() {
        return "Количество абзацев: " + paragraph + "\n"+
                "Количество предложений: "+sentence+"\n"+
                "Количество слов: "+word +"\n"+
                "Количество символов: "+symbol+"\n"+
                "Самое длинное слово: "+longWord;
    }



}
