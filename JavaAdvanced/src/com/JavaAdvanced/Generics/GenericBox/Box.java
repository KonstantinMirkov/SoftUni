package com.JavaAdvanced.Generics.GenericBox;

import java.util.*;

public class Box <T>{
    private List<T> elements;

    public Box(){
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        elements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        elements.forEach(element -> {
            builder.append(String.format("%s: %s",element.getClass().getName(), element));
            builder.append(System.lineSeparator());
        });

        return builder.toString();
    }
}
