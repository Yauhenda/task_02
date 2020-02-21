package main.java.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private List<TextComponent> components;
    private TextType textType;

    public TextComposite(TextType textType) {
        this.textType = textType;
    }

    @Override
    public TextType getTextType() {
        return textType;
    }

    public void setType(TextType textType) {
        this.textType = textType;
    }

    public List<TextComponent> getTextComponent() {
        return components;
    }

    public void addTextComponent(TextComponent textPart) {
        if (components == null) components = new ArrayList<>();
        components.add(textPart);
    }

    public void removeTextPartComponent(TextComponent textPart) {
        if (components != null) components.remove(textPart);
    }

    @Override
    public String printText() {
        StringBuffer stringBuffer = new StringBuffer();
        for (TextComponent textComponent : components) {
            stringBuffer.append(textComponent.printText());
        }
        return stringBuffer.toString();
    }

    @Override
    public String toString() {
        return "Text type = " + textType + components + "\n";
    }
}