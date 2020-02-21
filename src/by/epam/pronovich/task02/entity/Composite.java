package by.epam.pronovich.task02.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    List<Component> components = new ArrayList<>();

    @Override
    public void add(Component component) {
        components.add(component);
    }

    public List<Component> getComponents() {
        return components;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.toString());
        }
        return stringBuilder.toString();
    }

    @Override
    public int calcQuantity() {
        return components.size();
    }
}
