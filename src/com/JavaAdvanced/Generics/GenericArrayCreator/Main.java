package com.JavaAdvanced.Generics.GenericArrayCreator;

public class Main {
    public static void main(String[] args) {
        String[] test = ArrayCreator.<String>create(String.class, 13, "test");

        Integer[] integers = ArrayCreator.<Integer>create(String.class, 73, 69);

    }
}
