package com.JavaAdvanced.Generics.GenericSwapMethodStrings;

import java.util.*;

public class Box <T>{
    private List<T> elements;

    public Box(){
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex){
        T firstElements = this.elements.get(firstIndex);
        T secondElements = this.elements.get(secondIndex);

        this.elements.set(firstIndex, secondElements);
        this.elements.set(secondIndex, firstElements);
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
