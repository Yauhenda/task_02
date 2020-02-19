package by.epam.nickgrudnitsky.util;

public class Patterns {
    public static final String SYMBOL = ".|\n";
    public static final String WORD = "[a-zA-Z0-9]+|[ ,.?!;\n]";
    public static final String SENTENCE = "[A-Za-z0-9*+\\/-][A-Za-z0-9,;'\\\"\\s*+\\/-]*[.?!]+|[ ,.?!;\\n]";
    public static final String PARAGRAPH = " {4}.*?((?=( {4})|\\z))";
    public static final String REVERSE_POLISH_NOTATION = "\\{((\\{(([0-9]+\\.?[0-9]*),?)+}),?)+}|(?<![+/*=-])[+/*=)-]|[(]|(?<![A-Za-z]+[0-9]?)-?[0-9]+\\.?[0-9]*|[A-Za-z]+[0-9]?|\\{(([0-9]+\\.?[0-9]*),?)+}";
    public static final String SCALARS = "-?[0-9]+\\.?[0-9]*|[A-Za-z]+[0-9]?";
    public static final String EXPRESSION ="(\\(?(-?[0-9]+(\\.[0-9]+)?)([*+\\/\\-](-?[0-9]+(\\.[0-9]+)?))+\\)?)+([*+\\/-](\\(?(-?[0-9]+(\\.[0-9]+)?)([*+\\/\\-](-?[0-9]+(\\.[0-9]+)?))+\\)?)+)*";
}