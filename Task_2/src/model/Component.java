package model;

import java.util.List;

public interface Component<T> {
    List<Component> readText(String text, String delimiter);

    String writeText(T t);




}
