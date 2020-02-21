package com.epam.andrei_eremenko.task_02.two;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> partList = new ArrayList<>();

    public Composite() {
    }

    @Override
    public void addElement(Component part) {
        partList.add(part);
    }

    @Override
    public int getSize() {
        return partList.size();
    }

    @Override
    public void print() {
        for (Component c : partList) {
            c.print();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Component c : partList) {
            sb.append(c.toString());
        }
        return sb.toString();
    }


}
