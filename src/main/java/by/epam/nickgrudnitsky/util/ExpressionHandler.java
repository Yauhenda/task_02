package by.epam.nickgrudnitsky.util;

import by.epam.nickgrudnitsky.exeption.CalcException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionHandler {
    List<String> polishNotation = new ArrayList<>();
    LinkedList<String> stack = new LinkedList<>();
    String text;

    public ExpressionHandler(String text) {
        this.text = text;
    }

    public String replaceExpression() {
        List<String> expressions = searchExpressions(text);

        for (String expression : expressions) {
            String expressionResult = count(expression);
            insertResult(expressionResult, expression);
            polishNotation.clear();
            stack.clear();
        }
        return text;
    }

    private void insertResult(String result, String expression) {
        text = text.replace(expression, result);
    }

    private String count(String expression) {
        translateToPolishNotation(expression);
        String result;
        try {
            result = countResult();
        } catch (CalcException e) {
            return "ILLEGAL STATEMENT";
        }
        return result;
    }

    private List<String> searchExpressions(String text) {
        List<String> expressions = new ArrayList<>();
        Pattern pattern = Pattern.compile(Patterns.EXPRESSION);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            expressions.add(matcher.group());
        }
        return expressions;
    }

    private void translateToPolishNotation(String expression) {

        Pattern pattern = Pattern.compile(Patterns.REVERSE_POLISH_NOTATION);
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {

            Pattern pattern1 = Pattern.compile(Patterns.SCALARS);
            Matcher matcher1 = pattern1.matcher(matcher.group());

            if (matcher1.find()) {
                polishNotation.add(matcher.group());
                continue;
            }
            if (!matcher1.find()) {
                if (matcher.group().equals("(")) {
                    stack.push("(");
                } else if (matcher.group().equals(")")) {
                    while (!stack.getFirst().equals("(")) {
                        String pop = stack.pop();
                        polishNotation.add(pop);
                    }
                    stack.pop();
                } else if (!stack.isEmpty()) {
                    while (getPriority(matcher.group()) <= getPriority(stack.peek())) {
                        polishNotation.add(stack.pop());
                        if (stack.size() > 0) {
                            if (getPriority(matcher.group()) > getPriority(stack.peek())) {
                                stack.push(matcher.group());
                                break;
                            }
                        } else {
                            stack.push(matcher.group());
                            break;
                        }
                    }
                    if (stack.peek() != null && getPriority(matcher.group()) > getPriority(stack.peek())) {
                        stack.push(matcher.group());
                    }
                } else {
                    stack.push(matcher.group());
                }
            }
        }

        while (stack.size() > 0) {
            polishNotation.add(stack.pop());
        }

    }

    private String countResult() throws CalcException {
        int result = 0;
        for (String s : polishNotation) {
            Pattern pattern = Pattern.compile(Patterns.SCALARS);
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                stack.push(s);
            } else {
                int x2 = Integer.parseInt(stack.pop());
                int x1 = Integer.parseInt(stack.pop());

                switch (s) {
                    case "+":
                        result = x1 + x2;
                        break;
                    case "-":
                        result = x1 - x2;
                        break;
                    case "*":
                        result = x1 * x2;
                        break;
                    case "/":
                        if (x2 == 0) {
                            throw new CalcException();
                        }
                        result = x1 / x2;
                        break;
                }
                stack.push(String.valueOf(result));
            }
        }

        return String.valueOf(result);
    }

    private int getPriority(String s) {
        switch (s) {
            case "=":
                return 0;
            case "(":
                return 1;
            case ")":
                return 2;
            case "+":
            case "-":
                return 3;
            case "*":
            case "/":
                return 4;
            default:
                return 6;
        }
    }
}
