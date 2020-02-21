package main.java.entity;

public interface TextComponent {
    String printText();

    TextType getTextType();

    public enum TextType {
        TEXT, PARAGRAPH, SENTENCE, WORD, SYMBOL;

        private static final TextType[] values = values();

        private String RegexForSplit;

        static {
            TEXT.RegexForSplit = "(?<=\\n)";
            PARAGRAPH.RegexForSplit = "(?<=\\.+\\s)(?=[A-Z])";
            SENTENCE.RegexForSplit = "(?<=[^\\w])(?=\\w)|(?<=\\w)(?=[^\\w])|(?<=[^\\w])(?=[^\\w])";
            WORD.RegexForSplit = "(?<=\\w)";
        }

        public TextType getChild() {
            if (ordinal() == values.length) {
                return null;
            }
            return values[ordinal() + 1];
        }

        public String getRegexForSplit() {
            return RegexForSplit;
        }
    }
}