package by.epam.nickgrudnitsky.model.text;

import by.epam.nickgrudnitsky.util.ExpressionHandler;
import by.epam.nickgrudnitsky.util.Patterns;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text extends TextComponent {
    ExpressionHandler expressionHandler;

    public Text(String sentence) {
        if (!expressionProcessed) {
            expressionHandler = new ExpressionHandler(sentence);
            sentence = expressionHandler.replaceExpression();
            expressionProcessed = true;
        }

        for (Map.Entry<String, Pattern> patternEntry : patterns.entrySet()) {
            String patterName = patternEntry.getKey();
            Pattern pattern = patternEntry.getValue();
            Matcher matcher = pattern.matcher(sentence);
            int count = 0;

            while (matcher.find()) {
                count++;

            }
            if (count == 1) {
                textComponentName = patterName;

            }

            if (count > 1) {

                matcher = pattern.matcher(sentence);

                while (matcher.find()) {
                    String expression = matcher.group();

                    if (expression.matches(Patterns.SYMBOL)) {
                        text.add(new Symbol(expression));
                    } else {
                        text.add(new Text(expression));
                    }
                }
                return;
            }
        }
    }


    int getTextComponentCount(String textComponentName) {
        int textComponentCount = 0;

        for (TextComponent textComponent : text) {

            if (textComponent.textComponentName.equalsIgnoreCase(textComponentName)) {
                textComponentCount++;
            } else {
                textComponentCount += textComponent.getTextComponentCount(textComponentName);
            }
        }
        return textComponentCount;
    }

    public String getLongestWord() {
        TextComponent longestWord = new Text("");

        for (TextComponent textComponent : text) {

            if (textComponent.textComponentName.equals("WORD")) {
                if (textComponent.text.size() > longestWord.text.size()) {
                    longestWord = textComponent;
                }
                continue;
            }
            if (textComponent.textComponentName.equals("SYMBOL")) {
                continue;
            }
            return textComponent.getLongestWord();
        }
        return longestWord.toString();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent textComponent : text) {
            stringBuilder.append(textComponent.toString());
        }
        return stringBuilder.toString();
    }
}
